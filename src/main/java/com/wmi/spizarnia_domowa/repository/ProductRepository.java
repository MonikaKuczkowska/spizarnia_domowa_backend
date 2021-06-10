package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value = "select * from product where quantity != 0;", nativeQuery = true)
    List<Product> getAllWithoutZero();
}
