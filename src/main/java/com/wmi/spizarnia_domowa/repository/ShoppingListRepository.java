package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID> {
}
