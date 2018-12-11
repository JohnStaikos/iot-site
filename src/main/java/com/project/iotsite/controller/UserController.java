package com.project.iotsite.controller;

import com.project.iotsite.entity.User;
import com.project.iotsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/users")
//    public Collection<User> getAllUsers() {
//        return  userService.findAll();
//    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userService.findById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        User updated = userService.save(user);
        return new ResponseEntity<>(updated, HttpStatus.OK);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        User userDeleted = userService.findById(id);
        userService.delete(id);
        //return ResponseEntity.noContent().build();
        return new ResponseEntity<>(userDeleted, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> addUser(@RequestBody User user) {

        User saved = userService.save(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }





}