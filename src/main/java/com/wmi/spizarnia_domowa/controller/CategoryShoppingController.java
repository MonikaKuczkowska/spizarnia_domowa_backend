package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.CategoryShopping;
import com.wmi.spizarnia_domowa.service.CategoryShoppingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@ResponseBody
@RequestMapping("/category-shopping")
@AllArgsConstructor
public class CategoryShoppingController {
    private final CategoryShoppingService categoryShoppingService;

    @GetMapping("/all")
    public List<CategoryShopping> getAll() {
        return categoryShoppingService.getAll();
    }

    @GetMapping
    public CategoryShopping getById(@RequestParam UUID id) {
        return categoryShoppingService.getById(id);
    }

    @PostMapping
    public CategoryShopping addCategoryProduct(@RequestBody CategoryShopping categoryShopping) {
        return categoryShoppingService.save(categoryShopping);
    }
}
