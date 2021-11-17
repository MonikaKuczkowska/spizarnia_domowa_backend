package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.ExpirationDate;

import java.time.LocalDate;
import java.util.UUID;

public interface ExpirationDateService {
    ExpirationDate save(LocalDate date, int days, String note);
    void delete(UUID id);
}
