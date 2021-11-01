package com.wmi.spizarnia_domowa.service;

import com.wmi.spizarnia_domowa.model.Group;

public interface GroupService {
    Group save(Group group);
    Group getByCode(String code);
}
