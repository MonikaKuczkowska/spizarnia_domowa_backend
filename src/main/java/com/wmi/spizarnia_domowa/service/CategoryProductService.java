package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.CategoryProduct;

import java.util.List;
import java.util.UUID;

public interface CategoryProductService {
    List<CategoryProduct> getAll(String code);
    CategoryProduct getById(UUID id);
    CategoryProduct save(CategoryProduct categoryProduct);
    void delete(UUID id);
}
