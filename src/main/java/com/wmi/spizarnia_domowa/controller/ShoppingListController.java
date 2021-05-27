package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.ShoppingList;
import com.wmi.spizarnia_domowa.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping-list")
@AllArgsConstructor
public class ShoppingListController {
    private final ShoppingListService shoppingListService;

    @GetMapping("/all")
    public List<ShoppingList> getAll() {
        System.out.println(shoppingListService.getAll().size());
        return shoppingListService.getAll();
    }

    @PostMapping
    public ShoppingList addProductToShoppingList(@RequestBody ShoppingList shoppingList) {
        return shoppingListService.save(shoppingList);
    }
}
