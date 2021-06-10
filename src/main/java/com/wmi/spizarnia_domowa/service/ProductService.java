package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAll();
    Product getById(UUID id);
    Product save(Product product);
    Product addAttribute(UUID id, String attributeName);
    Product deleteAttribute(UUID id, UUID attributeId);
    Product updateQuantity(UUID id, int quantity);
    void decrementQuantity(UUID id);
}
