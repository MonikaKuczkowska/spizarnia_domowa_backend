package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.CategoryProduct;
import com.wmi.spizarnia_domowa.service.CategoryProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category-product")
@AllArgsConstructor
public class CategoryProductController {
    private final CategoryProductService categoryProductService;

    @GetMapping("/all")
    public List<CategoryProduct> getAll() {
        return categoryProductService.getAll();
    }

    @GetMapping
    public CategoryProduct getById(@RequestParam UUID id) {
        return categoryProductService.getById(id);
    }

    @PostMapping
    public CategoryProduct addCategoryProduct(@RequestBody CategoryProduct categoryProduct) {
        return categoryProductService.save(categoryProduct);
    }
}
