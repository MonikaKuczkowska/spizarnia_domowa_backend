package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.CategoryShopping;
import com.wmi.spizarnia_domowa.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryShoppingRepository extends JpaRepository<CategoryShopping, UUID> {

    List<CategoryShopping> findAllByGroup(Group group);

    CategoryShopping findByGroupAndName(Group group, String name);
}
