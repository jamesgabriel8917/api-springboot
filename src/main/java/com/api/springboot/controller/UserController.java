package com.api.springboot.controller;

import com.api.springboot.domain.model.User;
import com.api.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> findAll(){

        var users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        var userCreated = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

}
