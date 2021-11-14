package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.ExpirationDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpirationDateRepository extends JpaRepository<ExpirationDate, UUID> {
}
