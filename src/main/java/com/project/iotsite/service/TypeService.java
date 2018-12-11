package com.project.iotsite.service;

import com.project.iotsite.entity.Type;

import java.util.List;

public interface TypeService {

    List<Type> findByname(String name);

    List<Type> findAll();

    Type save(Type d);

    void delete(Long id);

    void delete(Type p);
}
