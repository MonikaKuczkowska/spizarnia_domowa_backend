package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.CategoryShopping;
import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.repository.CategoryShoppingRepository;
import com.wmi.spizarnia_domowa.repository.GroupRepository;
import com.wmi.spizarnia_domowa.service.CategoryShoppingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryShoppingServiceImpl implements CategoryShoppingService {
    private final CategoryShoppingRepository categoryShoppingRepository;
    private final GroupRepository groupRepository;

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
}
