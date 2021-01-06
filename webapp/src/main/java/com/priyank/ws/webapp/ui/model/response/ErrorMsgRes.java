package com.priyank.ws.webapp.ui.model.response;

import java.util.Date;

public class ErrorMsgRes {
    private Date date;
    private String message;

    public ErrorMsgRes() {
    }

    public ErrorMsgRes(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMsgRes date(Date date) {
        this.date = date;
        return this;
    }

    public ErrorMsgRes message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " date='" + getDate() + "'" +
            ", message='" + getMessage() + "'" +
            "}";
    }


    
}
