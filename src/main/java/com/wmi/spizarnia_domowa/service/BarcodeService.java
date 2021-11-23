package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.Barcode;

import java.util.UUID;

public interface BarcodeService {
    Barcode save(String barcode, String note);

    void delete(UUID id);
}
