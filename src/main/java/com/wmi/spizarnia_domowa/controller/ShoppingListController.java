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
    public List<ShoppingList> getAll(@RequestParam String code) {
        return shoppingListService.getAll(code);
    }

    @GetMapping("/all-sorted-category-shopping")
    public List<ShoppingList> getAllSortedByCategoryShopping(@RequestParam String code) {
        return shoppingListService.getAllSortedByCategoryShopping(code);
    }

    @PostMapping
    public ShoppingList addProductToShoppingList(@RequestBody ShoppingList shoppingList) {
        return shoppingListService.save(shoppingList);
    }

    @PostMapping("/buy/{id}")
    public void shoppingSuccess(@PathVariable UUID id, @RequestParam int quantity) {
        shoppingListService.productUpdate(id, quantity);
    }

    @PutMapping("/quantity/{id}")
    public ShoppingList updateQuantity(@PathVariable UUID id, @RequestParam int quantity) {
        return shoppingListService.updateQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        shoppingListService.delete(id);
    }
}
