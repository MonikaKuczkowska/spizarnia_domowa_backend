package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@ResponseBody
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {
    private GroupService groupService;

    @PostMapping
    public Group addGroup(@RequestBody Group group) {
        return groupService.save(group);
    }

    @GetMapping
    public Group getByCode(@RequestParam String code) {
        return groupService.getByCode(code);
    }
}
