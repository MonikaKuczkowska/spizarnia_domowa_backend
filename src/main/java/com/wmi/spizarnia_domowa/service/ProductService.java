package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAll(String code);

    List<Product> getAllWithoutZero(String code);

    List<Product> getAllSortedByCategoryProduct(String code);

    Product getById(UUID id);

    Product save(Product product);

    Product addAttribute(UUID id, String attributeName);

    Product addBarcode(UUID id, String barcode, String note);

    Product addExpirationDate(UUID id, LocalDate date, int days, String note);

    Product deleteAttribute(UUID id, UUID attributeId);

    Product deleteBarcode(UUID id, UUID barcodeId);

    Product deleteExpirationDate(UUID id, UUID expirationDateId);

    Product updateQuantity(UUID id, int quantity);

    Product updateProduct(Product product);

    void decrementQuantity(UUID id);

    void saveAll(List<Product> products);
}
