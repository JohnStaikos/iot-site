package com.project.iotsite.service;

import com.project.iotsite.entity.User;
import com.project.iotsite.repository.RoleRepository;
import com.project.iotsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
         @Autowired
         private UserRepository userRepository;

         @Autowired
         private RoleRepository userRoleRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public List<User> findByname(String name) {
        return userRepository.findByname(name);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User d) {
        userRepository.delete(d);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findByNameContaining(String searchterm){
        return userRepository.findByNameContaining(searchterm);
    }

    @Override
    public User findByPassword(String email){
        return userRepository.findByPassword(email);
    }

    @Override
    public User findOne(String username) {
        return null;
    }

    @Override
    public boolean findByUsernameBool(String username) {
       return (findByUsername(username).
               getUsername()==username);
    }

    @Override
    public User save(User user) {
        //encrypt the user password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //Set the user's role as a simple user
        user.setRole(userRoleRepository.findByName("USER"));
        userRepository.save(user);
        return userRepository.findByEmail(user.getEmail());
    }
    @Override
    public User findByEmail(String email){

        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findByRoleName(String role) {
        return userRepository.findByRole(role);
    }

}