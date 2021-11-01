package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.ShoppingList;

import java.util.List;
import java.util.UUID;

public interface ShoppingListService {
    List<ShoppingList> getAll(String code);
    List<ShoppingList> getAllSortedByCategoryShopping(String code);
    ShoppingList save(ShoppingList shoppingList);
    void productUpdate(UUID id, int quantity);
    void delete(UUID id);
}
