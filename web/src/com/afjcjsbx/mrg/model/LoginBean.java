package com.afjcjsbx.mrg.model;

/**
 * Created by afjcjsbx on 24/02/17.
 */
public class LoginBean {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate(){
        if(!username.isEmpty() || !password.isEmpty()){
            return true;
        }
        return false;
    }
}
