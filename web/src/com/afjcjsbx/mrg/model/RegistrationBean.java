package com.afjcjsbx.mrg.model;

/**
 * Created by afjcjsbx on 24/02/17.
 */
public class RegistrationBean {

    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean validate(){
        if(!username.isEmpty() || !password.isEmpty()){
            return true;
        }
        return false;
    }
}
