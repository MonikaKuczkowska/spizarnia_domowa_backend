package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.Attribute;

import java.util.UUID;

public interface AttributeService {
    Attribute save(String attributeName);
    void delete(UUID id);
}
