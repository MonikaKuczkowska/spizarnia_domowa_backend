package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.ShoppingList;
import com.wmi.spizarnia_domowa.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@ResponseBody
@RequestMapping("/shopping-list")
@AllArgsConstructor
public class ShoppingListController {
    private final ShoppingListService shoppingListService;

    @GetMapping("/all")
    public List<ShoppingList> getAll() {
        return shoppingListService.getAll();
    }

    @GetMapping("/all-sorted-category-shopping")
    public List<ShoppingList> getAllSortedByCategoryShopping() {
        return shoppingListService.getAllSortedByCategoryShopping();
    }

    @PostMapping
    public ShoppingList addProductToShoppingList(@RequestBody ShoppingList shoppingList) {
        return shoppingListService.save(shoppingList);
    }

    @PostMapping("/buy/{id}")
    public void shoppingSuccess(@RequestParam int quantity, @PathVariable UUID id) {
        shoppingListService.productUpdate(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        shoppingListService.delete(id);
    }
}
