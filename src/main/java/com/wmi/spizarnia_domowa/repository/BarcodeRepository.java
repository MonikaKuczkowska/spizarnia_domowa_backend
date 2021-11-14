package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BarcodeRepository extends JpaRepository<Barcode, UUID> {
}
