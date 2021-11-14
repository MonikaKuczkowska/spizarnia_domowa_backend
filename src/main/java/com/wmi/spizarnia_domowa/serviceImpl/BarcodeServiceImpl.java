package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Barcode;
import com.wmi.spizarnia_domowa.repository.BarcodeRepository;
import com.wmi.spizarnia_domowa.service.BarcodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BarcodeServiceImpl implements BarcodeService {
    private final BarcodeRepository barcodeRepository;

    @Override
    public Barcode save(String barcode, String note){
        Barcode barcodeToSave = new Barcode();
        barcodeToSave.setBarcode(barcode);
        barcodeToSave.setNote(note);
        return barcodeRepository.save(barcodeToSave);
    }

    @Override
    public void delete(UUID id) {
        barcodeRepository.deleteById(id);
    }
}
