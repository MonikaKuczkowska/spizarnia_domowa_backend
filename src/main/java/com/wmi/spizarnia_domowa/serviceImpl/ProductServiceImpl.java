package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Attribute;
import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.model.ShoppingList;
import com.wmi.spizarnia_domowa.repository.AttributeRepository;
import com.wmi.spizarnia_domowa.repository.ProductRepository;
import com.wmi.spizarnia_domowa.service.AttributeService;
import com.wmi.spizarnia_domowa.service.ProductService;
import com.wmi.spizarnia_domowa.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final AttributeRepository attributeRepository;
    private final AttributeService attributeService;
    private final ShoppingListService shoppingListService;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
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
    public void decrementQuantity(UUID id) {
        Product product = getById(id);
        product.setQuantity(product.getQuantity() - 1);
        save(product);
        isUnderCountQuantity(id);
    }

    private void isUnderCountQuantity(UUID id) {
        Product product = getById(id);
        if (product.isAutoPurchase()) {
            if (product.getQuantity() <= product.getAutoPurchaseCount()) {
                ShoppingList shoppingList = new  ShoppingList();
                shoppingList.setQuantityToBuy(1);
                shoppingList.setProduct(product);
                shoppingListService.save(shoppingList);
            }
        }
    }
}
