package com.project.iotsite.service;

import com.project.iotsite.entity.User;

import java.util.List;

public interface UserService {


    List<User> findByname(String name);

    List<User> findAll();

    User save(User user);

    void delete(Long id);

    void delete(User p);

    User findById(long id);

    User findByUsername(String username);

    List<User> findByNameContaining(String searchterm);


    User findByPassword(String email);

    User findOne(String username);

    boolean findByUsernameBool(String username);

    List<User> findByRoleName(String role);

    User findByEmail(String email);
}

