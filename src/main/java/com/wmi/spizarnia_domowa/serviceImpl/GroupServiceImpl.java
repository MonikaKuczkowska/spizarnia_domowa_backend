package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.repository.GroupRepository;
import com.wmi.spizarnia_domowa.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getByCode(String code) {
        return groupRepository.getByCode(code);
    }
}
