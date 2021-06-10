package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.model.ShoppingList;
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

    public ShoppingListServiceImpl(ShoppingListRepository shoppingListRepository, @Lazy ProductService productService) {
        this.shoppingListRepository = shoppingListRepository;
        this.productService = productService;
    }

    @Override
    public List<ShoppingList> getAll() {
        return shoppingListRepository.findAll();
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

    public void delete(UUID id) {
        shoppingListRepository.deleteById(id);
    }
}
