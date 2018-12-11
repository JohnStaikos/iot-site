package com.project.iotsite.repository;

import com.project.iotsite.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository("typeRepository")
public interface TypeRepository extends JpaRepository<Type, Long> {

    List<Type> findAll();

    List<Type> findByname(String name);

}

