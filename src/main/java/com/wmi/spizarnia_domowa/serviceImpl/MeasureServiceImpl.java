package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Measure;
import com.wmi.spizarnia_domowa.model.Product;
import com.wmi.spizarnia_domowa.repository.MeasureRepository;
import com.wmi.spizarnia_domowa.repository.ProductRepository;
import com.wmi.spizarnia_domowa.service.MeasureService;
import com.wmi.spizarnia_domowa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MeasureServiceImpl implements MeasureService {
    private final MeasureRepository measureRepository;

    @Override
    public List<Measure> getAll() {
        return measureRepository.findAll();
    }

    @Override
    public Measure getById(UUID id) {
        return measureRepository.findById(id).get();
    }

    @Override
    public Measure save(Measure measure) {
        return measureRepository.save(measure);
    }
}
