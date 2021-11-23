package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Attribute;
import com.wmi.spizarnia_domowa.repository.AttributeRepository;
import com.wmi.spizarnia_domowa.service.AttributeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AttributeServiceImpl implements AttributeService {
    private final AttributeRepository attributeRepository;

    @Override
    public Attribute save(String attributeName) {
        Attribute attribute = new Attribute();
        attribute.setName(attributeName);
        return attributeRepository.save(attribute);
    }

    @Override
    public void delete(UUID id) {
        attributeRepository.deleteById(id);
    }
}
