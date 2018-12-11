package com.project.iotsite.service;

import com.project.iotsite.entity.Type;
import com.project.iotsite.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImp implements TypeService {
    @Autowired
    private TypeRepository typeRep;

    @Override
    public List<Type> findByname(String name) {
        return typeRep.findByname(name);
    }

    @Override
    public List<Type> findAll() {
        return typeRep.findAll();
    }

    @Override
    public Type save(Type d) {
        return typeRep.save(d);
    }

    @Override
    public void delete(Long id) {
        typeRep.deleteById(id);
    }

    @Override
    public void delete(Type d) {
        typeRep.delete(d);
    }
}
