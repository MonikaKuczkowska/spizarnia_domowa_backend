package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.model.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, UUID> {

    List<Measure> findAllByGroup(Group group);

    Measure findByGroupAndName(Group group, String name);
}
