package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.CategoryProduct;
import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.repository.CategoryProductRepository;
import com.wmi.spizarnia_domowa.repository.GroupRepository;
import com.wmi.spizarnia_domowa.service.CategoryProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryProductServiceImpl implements CategoryProductService {
    private final CategoryProductRepository categoryProductRepository;
    private final GroupRepository groupRepository;

    @Override
    public List<CategoryProduct> getAll(String code) {
        Group group = groupRepository.getByCode(code);
        return categoryProductRepository.findAllByGroup(group);
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
