package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.model.ShoppingList;
import com.wmi.spizarnia_domowa.repository.GroupRepository;
import com.wmi.spizarnia_domowa.repository.ShoppingListRepository;
import com.wmi.spizarnia_domowa.service.ProductService;
import com.wmi.spizarnia_domowa.service.ShoppingListService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;
    private final ProductService productService;
    private final GroupRepository groupRepository;

    public ShoppingListServiceImpl(ShoppingListRepository shoppingListRepository, @Lazy ProductService productService, GroupRepository groupRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.productService = productService;
        this.groupRepository = groupRepository;
    }

    @Override
    public List<ShoppingList> getAll(String code) {
        Group group = groupRepository.getByCode(code);
        return shoppingListRepository.findAllByGroup(group);
    }

    @Override
    public List<ShoppingList> getAllSortedByCategoryShopping(String code) {
        return shoppingListRepository.getAllSortedByCategoryShopping(code);
    }

    @Override
    public ShoppingList save(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    @Transactional
    @Override
    public void productUpdate(UUID id, int quantity) {
        Product product = productService.getById(shoppingListRepository.getById(id).getProduct().getId());
        product.setQuantity(product.getQuantity() + quantity);
        productService.save(product);
        delete(id);
    }

    @Override
    public ShoppingList updateQuantity(UUID id, int quantity) {
        ShoppingList shoppingList = shoppingListRepository.getById(id);
        shoppingList.setQuantityToBuy(quantity);

        return save(shoppingList);
    }

    public void delete(UUID id) {
        shoppingListRepository.deleteById(id);
    }
}
