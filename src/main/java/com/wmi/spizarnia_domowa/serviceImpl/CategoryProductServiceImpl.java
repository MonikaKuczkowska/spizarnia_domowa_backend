package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.CategoryProduct;
import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.repository.CategoryProductRepository;
import com.wmi.spizarnia_domowa.repository.GroupRepository;
import com.wmi.spizarnia_domowa.service.CategoryProductService;
import com.wmi.spizarnia_domowa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryProductServiceImpl implements CategoryProductService {
    private final CategoryProductRepository categoryProductRepository;
    private final GroupRepository groupRepository;
    private final ProductService productService;

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

    @Transactional
    @Override
    public void delete(UUID id) {
        CategoryProduct categoryProduct = categoryProductRepository.getById(id);
        Group group = categoryProduct.getGroup();
        List<Product> products = productService.getAll(group.getCode());
        CategoryProduct defaultCategoryProduct = getDefaultByGroup(group);
        for (Product product:products) {
            if (product.getCategoryProduct().getId() == id) {
                product.setCategoryProduct(defaultCategoryProduct);
            }
        }
        productService.saveAll(products);
        categoryProductRepository.delete(categoryProduct);
    }

    private CategoryProduct getByGroupAndName(Group group, String name) {
        return categoryProductRepository.findByGroupAndName(group, name);
    }

    private CategoryProduct getDefaultByGroup(Group group) {
        String defaultCategoryName = "Inne";
        return getByGroupAndName(group, defaultCategoryName);
    }
}
