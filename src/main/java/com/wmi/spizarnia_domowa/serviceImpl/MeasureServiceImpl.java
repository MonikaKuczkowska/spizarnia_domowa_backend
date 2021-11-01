package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.model.Measure;
import com.wmi.spizarnia_domowa.repository.GroupRepository;
import com.wmi.spizarnia_domowa.repository.MeasureRepository;
import com.wmi.spizarnia_domowa.service.MeasureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MeasureServiceImpl implements MeasureService {
    private final MeasureRepository measureRepository;
    private final GroupRepository groupRepository;

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
}
