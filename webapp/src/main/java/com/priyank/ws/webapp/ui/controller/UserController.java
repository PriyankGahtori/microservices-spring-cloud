package com.priyank.ws.webapp.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.priyank.ws.webapp.ui.model.request.UpdateUserDTO;
import com.priyank.ws.webapp.ui.model.request.UserReq;
import com.priyank.ws.webapp.ui.model.response.UserRes;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String,UserRes> cache = new HashMap<>();

    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserRes> getUser(@PathVariable String userId) {
        UserRes user = cache.get(userId);
        if(null == user)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<UserRes>(user, HttpStatus.OK);    
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserReq> getUser(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "30", required = true) int limit,
            @RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {

                //throw new NullPointerException();
             String str = null;
             str.length();
        UserReq user = new UserReq();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("email"); 
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }


    @PostMapping
    public ResponseEntity<UserRes> createUser(@Valid @RequestBody UserReq user) {

        UserRes uResp = new UserRes();
        String userId = UUID.randomUUID().toString();   

        uResp.setFirstName(user.getFirstName());
        uResp.setLastName(user.getLastName());
        uResp.setEmail(user.getEmail());
        uResp.setUserId(userId);
        
        cache.put(userId, uResp);

        return new ResponseEntity<>(uResp, HttpStatus.CREATED);
    }
    
    // @PostMapping
    // public String createUser() {
    //     return "Create USer was called";
    // }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<UserRes> updateUser(@PathVariable String userId, @Valid  @RequestBody UpdateUserDTO user) {
        
        UserRes cachedUser = cache.get(userId);
        
        if(null == cachedUser)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        cachedUser.setFirstName(user.getFirstName());
        cachedUser.setLastName(user.getLastName());
        cache.put(userId, cachedUser);

        return new ResponseEntity<>(cachedUser, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        
        UserRes cachedUser = cache.get(userId);
        
        if(null == cachedUser)
            return ResponseEntity.notFound().build();
        
        cache.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
