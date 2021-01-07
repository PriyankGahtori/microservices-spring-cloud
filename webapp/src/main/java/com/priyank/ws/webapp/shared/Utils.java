package com.priyank.ws.webapp.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;
@Service
public class Utils {
    public String getRandomId()
    {
        return UUID.randomUUID().toString();
    }
}
