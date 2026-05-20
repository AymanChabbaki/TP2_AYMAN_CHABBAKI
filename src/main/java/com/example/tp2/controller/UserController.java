package com.example.tp2.controller;

import com.example.tp2.model.User;
import com.example.tp2.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{p}")
    public User getUser(@PathVariable("p") Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/update/{p}")
    public void updateUser(@PathVariable("p") Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/supp")
    public void suppUser(@RequestParam("p") Long id) {
        userService.suppUser(id);
    }
}
