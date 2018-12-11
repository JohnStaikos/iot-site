package com.project.iotsite.repository;

import com.project.iotsite.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
    List<Role> findAll();
    List<Role> findByname(String name);

}