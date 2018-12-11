package com.project.iotsite.repository;

import com.project.iotsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    List<User> findByname(String name);

    User findById(long id);

    User findByUsername(String username);

    List<User> findByNameContaining(String searchterm);

    User findByPassword(String email);


    List<User> findByRole(String role);

    User findByEmail(String email);
}

