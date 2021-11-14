package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<Product> getAll(@RequestParam String code) {
        return productService.getAll(code);
    }

    @GetMapping("/all-no-zero")
    public List<Product> getAllWithoutZero(@RequestParam String code) {
        return productService.getAllWithoutZero(code);
    }

    @GetMapping("/all-sorted-category-product")
    public List<Product> getAllSortedByCategoryProduct(@RequestParam String code) {
        return productService.getAllSortedByCategoryProduct(code);
    }

    @GetMapping
    public Product getById(@RequestParam UUID id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/attribute/{id}")
    public Product addAttribute(@PathVariable UUID id, @RequestParam String attributeName) {
        return productService.addAttribute(id, attributeName);
    }

    @PutMapping("/barcode/{id}")
    public Product addBarcode(@PathVariable UUID id, @RequestParam String barcode, @RequestParam String note) {
        return productService.addBarcode(id, barcode, note);
    }

    @PutMapping("/exp-date/{id}")
    public Product addExpirationDate(@PathVariable UUID id, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam int days) {
        return productService.addExpirationDate(id, date, days);
    }

    @PutMapping("/quantity/{id}")
    public Product updateQuantity(@PathVariable UUID id, @RequestParam int quantity) {
        return productService.updateQuantity(id, quantity);
    }

    @DeleteMapping("/attribute/{id}")
    public Product deleteAttribute(@PathVariable UUID id, @RequestParam UUID attributeId) {
        return productService.deleteAttribute(id, attributeId);
    }

    @DeleteMapping("/barcode/{id}")
    public Product deleteBarcode(@PathVariable UUID id, @RequestParam UUID barcodeId) {
        return productService.deleteBarcode(id, barcodeId);
    }

    @DeleteMapping("/exp-date/{id}")
    public Product deleteExpirationDate(@PathVariable UUID id, @RequestParam UUID expirationDateId) {
        return productService.deleteExpirationDate(id, expirationDateId);
    }

    @PutMapping("/all/{id}")
    public void autoPurchase(@PathVariable UUID id) {
        productService.decrementQuantity(id);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

}
