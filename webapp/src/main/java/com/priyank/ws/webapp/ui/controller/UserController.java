package com.priyank.ws.webapp.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getUser() {
        return "GET user called";
    }

    @PostMapping
    public String createUser() {
        return "Create USer was called";
    }

    @PutMapping
    public String updateUser() {
        return "Update User Called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete User Called";
    }
}
