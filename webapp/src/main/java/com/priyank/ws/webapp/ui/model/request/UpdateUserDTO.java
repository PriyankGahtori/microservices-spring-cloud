package com.priyank.ws.webapp.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDTO {
    @NotNull(message = "First Name can't be null")
    @Size(min = 2, message = "FirstName should be atlest 2 char")
    private String firstName;

    @NotNull(message = "Last Name can't be null")
    @Size(min = 2, message = "lastName should be atlest 2 char")
    private String lastName;


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UpdateUserDTO() {
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
