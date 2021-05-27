package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.CategoryShopping;

import java.util.List;
import java.util.UUID;

public interface CategoryShoppingService {
    List<CategoryShopping> getAll();
    CategoryShopping getById(UUID id);
    CategoryShopping save(CategoryShopping categoryShopping);
}
