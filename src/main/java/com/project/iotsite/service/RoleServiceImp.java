package com.project.iotsite.service;

import com.project.iotsite.entity.Role;
import com.project.iotsite.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRep;

    @Override
    public List<Role> findByname(String name) {
        return roleRep.findByname(name);
    }

    @Override
    public List<Role> findAll() {
        return roleRep.findAll();
    }

    @Override
    public Role save(Role d) {
        return roleRep.save(d);
    }

    @Override
    public void delete(Long id) {
        roleRep.deleteById(id);
    }

    @Override
    public void delete(Role d) {
        roleRep.delete(d);
    }

}

