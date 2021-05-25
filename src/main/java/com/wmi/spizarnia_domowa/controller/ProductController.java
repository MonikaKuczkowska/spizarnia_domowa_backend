package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping
    public Product getById(@RequestParam UUID id) {
        return productService.getById(id);
    }
}
