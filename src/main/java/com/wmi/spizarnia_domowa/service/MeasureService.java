package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.Measure;

import java.util.List;
import java.util.UUID;

public interface MeasureService {
    List<Measure> getAll(String code);
    Measure getById(UUID id);
    Measure save(Measure measure);
    void delete(UUID id);
}
