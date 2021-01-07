package com.priyank.ws.webapp.ui.service;

import com.priyank.ws.webapp.ui.model.request.UserReq;
import com.priyank.ws.webapp.ui.model.response.UserRes;

public interface UserService {
    UserRes createUser(UserReq user);   
}
