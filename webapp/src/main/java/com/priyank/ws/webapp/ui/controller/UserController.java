package com.priyank.ws.webapp.ui.controller;

import javax.print.attribute.standard.Media;

import com.priyank.ws.webapp.ui.model.request.UserReq;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId) {
        return "GET user called with userId = " + userId;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserReq getUser(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "30", required = true) int limit,
            @RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
        //return "GET user called with page = " + page + " limt = " + limit + " Sorting " + sort;


        UserReq user = new UserReq();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("email");
        return user;

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
