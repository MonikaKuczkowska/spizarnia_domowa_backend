package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.repository.ProductRepository;
import com.wmi.spizarnia_domowa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(UUID id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
