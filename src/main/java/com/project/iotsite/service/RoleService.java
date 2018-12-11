package com.project.iotsite.service;


import com.project.iotsite.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findByname(String name);

    List<Role> findAll();

    Role save(Role d);

    void delete(Long id);

    void delete(Role p);
}
