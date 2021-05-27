package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.Attribute;
import com.wmi.spizarnia_domowa.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAll();
    Product getById(UUID id);
    Product save(Product product);
    Product addAttribute(UUID id, String attributeName);
    void decrementQuantity(UUID id);
}
