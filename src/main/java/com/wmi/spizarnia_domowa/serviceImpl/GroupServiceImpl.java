package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.CategoryProduct;
import com.wmi.spizarnia_domowa.model.CategoryShopping;
import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.model.Measure;
import com.wmi.spizarnia_domowa.repository.GroupRepository;
import com.wmi.spizarnia_domowa.service.CategoryProductService;
import com.wmi.spizarnia_domowa.service.CategoryShoppingService;
import com.wmi.spizarnia_domowa.service.GroupService;
import com.wmi.spizarnia_domowa.service.MeasureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final MeasureService measureService;
    private final CategoryProductService categoryProductService;
    private final CategoryShoppingService categoryShoppingService;

    @Override
    public Group save(String name) {
        Group group = new Group();
        group.setName(name);
        Group groupSaved = groupRepository.save(group);

        initMeasures(groupSaved);
        initCategoryProduct(groupSaved);
        initCategoryShopping(groupSaved);

        return groupSaved;
    }

    @Override
    public Group getByCode(String code) {
        return groupRepository.getByCode(code);
    }

    private void initMeasures(Group group) {
        Measure measure = new Measure();
        measure.setGroup(group);
        measure.setName("Inne");

        measureService.save(measure);
    }

    private void initCategoryProduct(Group group) {
        CategoryProduct categoryProduct = new CategoryProduct();
        categoryProduct.setGroup(group);
        categoryProduct.setName("Inne");

        categoryProductService.save(categoryProduct);
    }

    private void initCategoryShopping(Group group) {
        CategoryShopping categoryShopping = new CategoryShopping();
        categoryShopping.setGroup(group);
        categoryShopping.setName("Inne");

        categoryShoppingService.save(categoryShopping);
    }
}
