package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.CategoryShopping;
import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.repository.CategoryShoppingRepository;
import com.wmi.spizarnia_domowa.repository.GroupRepository;
import com.wmi.spizarnia_domowa.service.CategoryShoppingService;
import com.wmi.spizarnia_domowa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryShoppingServiceImpl implements CategoryShoppingService {
    private final CategoryShoppingRepository categoryShoppingRepository;
    private final GroupRepository groupRepository;
    private final ProductService productService;

    @Override
    public List<CategoryShopping> getAll(String code) {
        Group group = groupRepository.getByCode(code);
        return categoryShoppingRepository.findAllByGroup(group);
    }

    @Override
    public CategoryShopping getById(UUID id) {
        return categoryShoppingRepository.findById(id).get();
    }

    @Override
    public CategoryShopping save(CategoryShopping categoryShopping) {
        return categoryShoppingRepository.save(categoryShopping);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        CategoryShopping categoryShopping = categoryShoppingRepository.getById(id);
        Group group = categoryShopping.getGroup();
        List<Product> products = productService.getAll(group.getCode());
        CategoryShopping defaultCategoryShopping = getDefaultByGroup(group);
        for (Product product : products) {
            if (product.getCategoryShopping().getId() == id) {
                product.setCategoryShopping(defaultCategoryShopping);
            }
        }
        productService.saveAll(products);
        categoryShoppingRepository.delete(categoryShopping);
    }

    private CategoryShopping getByGroupAndName(Group group, String name) {
        return categoryShoppingRepository.findByGroupAndName(group, name);
    }

    private CategoryShopping getDefaultByGroup(Group group) {
        String defaultCategoryName = "Inne";
        return getByGroupAndName(group, defaultCategoryName);
    }
}
