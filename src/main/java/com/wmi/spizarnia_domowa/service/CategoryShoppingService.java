package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.CategoryShopping;

import java.util.List;
import java.util.UUID;

public interface CategoryShoppingService {
    List<CategoryShopping> getAll(String code);

    CategoryShopping getById(UUID id);

    CategoryShopping save(CategoryShopping categoryShopping);

    void delete(UUID id);
}
