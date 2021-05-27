package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.Measure;

import java.util.List;
import java.util.UUID;

public interface MeasureService {
    List<Measure> getAll();
    Measure getById(UUID id);
    Measure save(Measure measure);
}
