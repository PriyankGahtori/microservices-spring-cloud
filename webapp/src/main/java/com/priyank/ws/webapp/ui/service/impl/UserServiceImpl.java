package com.priyank.ws.webapp.ui.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.priyank.ws.webapp.shared.Utils;
import com.priyank.ws.webapp.ui.model.request.UserReq;
import com.priyank.ws.webapp.ui.model.response.UserRes;
import com.priyank.ws.webapp.ui.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Map<String,UserRes> cache;
    private Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRes createUser(UserReq user) {
        UserRes uResp = new UserRes();
        String userId = utils.getRandomId(); 

        uResp.setFirstName(user.getFirstName());
        uResp.setLastName(user.getLastName());
        uResp.setEmail(user.getEmail());
        uResp.setUserId(userId);
        
        if(cache == null) cache =new HashMap<>();

        cache.put(userId, uResp);

        return uResp;
    }

    
}
