package com.project.iotsite.controller;

import com.project.iotsite.entity.Type;
import com.project.iotsite.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public Collection<Type> getAllTypes() {

        return typeService.findAll();
    }
}
