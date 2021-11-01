package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.*;
import com.wmi.spizarnia_domowa.repository.*;
import com.wmi.spizarnia_domowa.service.AttributeService;
import com.wmi.spizarnia_domowa.service.ProductService;
import com.wmi.spizarnia_domowa.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final AttributeRepository attributeRepository;
    private final AttributeService attributeService;
    private final ShoppingListService shoppingListService;
    private final GroupRepository groupRepository;

    @Override
    public List<Product> getAll(String code) {
        Group group = groupRepository.getByCode(code);
        return productRepository.findAllByGroup(group);
    }

    @Override
    public List<Product> getAllWithoutZero(String code) {
        return productRepository.getAllWithoutZero(code);
    }

    @Override
    public List<Product> getAllSortedByCategoryProduct(String code) {
        return productRepository.getAllSortedByCategoryProduct(code);
    }

    @Override
    public Product getById(UUID id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Product addAttribute(UUID id, String attributeName) {
        Attribute attribute = attributeService.save(attributeName);
        Product product = getById(id);
        List<Attribute> list = product.getAttributeList();
        list.add(attribute);
        product.setAttributeList(list);
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Product deleteAttribute(UUID id, UUID attributeId) {
        Attribute attribute = attributeRepository.getById(attributeId);
        attributeService.delete(attributeId);
        Product product = getById(id);
        List<Attribute> list = product.getAttributeList();
        list.remove(attribute);
        product.setAttributeList(list);
        return productRepository.getById(id);
    }

    @Override
    public Product updateQuantity(UUID id, int quantity) {
        Product product = productRepository.getById(id);
        product.setQuantity(quantity);
        productRepository.save(product);
        isUnderCountQuantity(id);
        return save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        String name = product.getProductName();
        int quantity = product.getQuantity();
        int autoPurchaseCount = product.getAutoPurchaseCount();
        boolean autoPurchase = product.isAutoPurchase();
        CategoryProduct categoryProduct = product.getCategoryProduct();
        CategoryShopping categoryShopping = product.getCategoryShopping();
        Measure measure = product.getMeasure();

        Product productUpdated = getById(product.getId());

        productUpdated.setProductName(name);
        productUpdated.setCategoryProduct(categoryProduct);
        productUpdated.setCategoryShopping(categoryShopping);
        productUpdated.setAutoPurchase(autoPurchase);
        productUpdated.setAutoPurchaseCount(autoPurchaseCount);
        productUpdated.setQuantity(quantity);
        productUpdated.setMeasure(measure);

        return save(productUpdated);
    }

    @Override
    public void decrementQuantity(UUID id) {
        Product product = getById(id);
        product.setQuantity(product.getQuantity() - 1);
        save(product);
        isUnderCountQuantity(id);
    }

    private void isUnderCountQuantity(UUID id) {
        Product product = getById(id);
        if (product.isAutoPurchase()) {
            if (product.getQuantity() < product.getAutoPurchaseCount()) {
                ShoppingList shoppingList = new ShoppingList();
                shoppingList.setQuantityToBuy(product.getAutoPurchaseCount() - product.getQuantity());
                shoppingList.setProduct(product);
                shoppingListService.save(shoppingList);
            }
        }
    }
}
