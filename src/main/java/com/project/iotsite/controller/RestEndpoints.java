package com.project.iotsite.controller;


import com.project.iotsite.entity.User;
import com.project.iotsite.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
class RestEndpoints {
    @Autowired
    UserServiceImp userService;
    @Autowired
    AuthenticationManager customAuthenticationManager;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @RequestMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> login(@RequestBody User user)  {


        System.err.println("kappa di kippo");
        HttpHeaders responseHeaders= new HttpHeaders();

        responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,"Content-Type");
        responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
                                            "GET, POST, OPTIONS");
        responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"http://localhost:4200");
        return new ResponseEntity<>(user,responseHeaders,HttpStatus.OK);
       // customAuthenticationManager.authenticate();
        //    return user.getToken();
    }
    @RequestMapping("/users")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }

}

