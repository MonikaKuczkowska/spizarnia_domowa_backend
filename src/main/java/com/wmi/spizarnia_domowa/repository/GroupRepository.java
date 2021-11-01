package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, String> {
    Group getByCode(String code);
}
