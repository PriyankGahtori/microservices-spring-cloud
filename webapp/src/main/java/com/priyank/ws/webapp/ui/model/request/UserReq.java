package com.priyank.ws.webapp.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class UserReq {
    @NotNull
    @Size(min = 2, max=8, message="Fist name should be min 2 char and Max 8 char")
    private String firstName;
    
    @NotNull
    private String lastName;
    
    @NotNull
    private int id;

    @NotNull
    @Email(message = "Email Address is not valid")
    private String email;
    
    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "Password should be min of 8 char")
    private String password;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserReq() {
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
}
