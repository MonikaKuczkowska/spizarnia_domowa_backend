package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.CategoryProduct;
import com.wmi.spizarnia_domowa.service.CategoryProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@ResponseBody
@RequestMapping("/category-product")
@AllArgsConstructor
public class CategoryProductController {
    private final CategoryProductService categoryProductService;

    @GetMapping("/all")
    public List<CategoryProduct> getAll(@RequestParam String code) {
        return categoryProductService.getAll(code);
    }

    @GetMapping
    public CategoryProduct getById(@RequestParam UUID id) {
        return categoryProductService.getById(id);
    }

    @PostMapping
    public CategoryProduct addCategoryProduct(@RequestBody CategoryProduct categoryProduct) {
        return categoryProductService.save(categoryProduct);
    }

    @DeleteMapping
    public void deleteCategoryProduct(@RequestParam UUID id) {
        categoryProductService.delete(id);
    }
}
