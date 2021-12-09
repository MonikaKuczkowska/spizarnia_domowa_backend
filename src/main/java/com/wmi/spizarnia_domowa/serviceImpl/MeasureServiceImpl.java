package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.model.Measure;
import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.repository.GroupRepository;
import com.wmi.spizarnia_domowa.repository.MeasureRepository;
import com.wmi.spizarnia_domowa.service.MeasureService;
import com.wmi.spizarnia_domowa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MeasureServiceImpl implements MeasureService {
    private final MeasureRepository measureRepository;
    private final GroupRepository groupRepository;
    private final ProductService productService;

    @Override
    public List<Measure> getAll(String code) {
        Group group = groupRepository.getByCode(code);
        return measureRepository.findAllByGroup(group);
    }

    @Override
    public Measure getById(UUID id) {
        return measureRepository.findById(id).get();
    }

    @Override
    public Measure save(Measure measure) {
        return measureRepository.save(measure);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        Measure measure = measureRepository.getById(id);
        Group group = measure.getGroup();
        List<Product> products = productService.getAll(group.getCode());
        Measure defaultMeasure = getDefaultByGroup(group);
        for (Product product : products) {
            if (product.getMeasure().getId() == id) {
                product.setMeasure(defaultMeasure);
            }
        }
        productService.saveAll(products);
        measureRepository.delete(measure);
    }

    private Measure getByGroupAndName(Group group, String name) {
        return measureRepository.findByGroupAndName(group, name);
    }

    private Measure getDefaultByGroup(Group group) {
        String defaultCategoryName = "Inne";
        return getByGroupAndName(group, defaultCategoryName);
    }
}
