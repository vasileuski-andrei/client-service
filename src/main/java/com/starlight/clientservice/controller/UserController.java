package com.starlight.clientservice.controller;

import com.starlight.clientservice.model.User;
import com.starlight.clientservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = userService.getAll();
        return users;
    }

    @PostMapping("/user")
    public User addNewUser(@RequestBody User user) {

        userService.save(user);

        return user;
    }






}
