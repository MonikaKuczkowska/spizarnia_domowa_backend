package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, UUID> {
}
