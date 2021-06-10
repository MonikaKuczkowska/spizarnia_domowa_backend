package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@ResponseBody
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/all-no-zero")
    public List<Product> getAllWithoutZero() {
        return productService.getAllWithoutZero();
    }

    @GetMapping
    public Product getById(@RequestParam UUID id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    //Dodawanie atrybutu
    @PutMapping("/attribute/{id}")
    public Product addAttribute(@PathVariable UUID id, @RequestParam String attributeName) {
        return productService.addAttribute(id, attributeName);
    }

    //Edytowanie ilosci
    @PutMapping("/quantity/{id}")
    public Product updateQuantity(@PathVariable UUID id, @RequestParam int quantity) {
        return productService.updateQuantity(id, quantity);
    }

    //Usuwanie atrubutu
    @DeleteMapping("/attribute/{id}")
    public Product deleteAttribute(@PathVariable UUID id, @RequestParam UUID attributeId) {
        return productService.deleteAttribute(id, attributeId);
    }

    //Dekrementacja ilosci produktu
    @PutMapping("/all/{id}")
    public void autoPurchase(@PathVariable UUID id) {
        productService.decrementQuantity(id);
    }

    //Edytowanie całego produktu
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

}
