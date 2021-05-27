package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.CategoryProduct;
import com.wmi.spizarnia_domowa.repository.CategoryProductRepository;
import com.wmi.spizarnia_domowa.service.CategoryProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryProductServiceImpl implements CategoryProductService {
    private final CategoryProductRepository categoryProductRepository;

    @Override
    public List<CategoryProduct> getAll() {
        return categoryProductRepository.findAll();
    }

    @Override
    public CategoryProduct getById(UUID id) {
        return categoryProductRepository.findById(id).get();
    }

    @Override
    public CategoryProduct save(CategoryProduct categoryProduct) {
        return categoryProductRepository.save(categoryProduct);
    }
}
