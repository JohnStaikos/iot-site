package com.project.iotsite.controller;

import com.project.iotsite.entity.Role;
import com.project.iotsite.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public Collection<Role> getAllRoles() {

        return roleService.findAll();
    }
}
