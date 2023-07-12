package com.pandorapharmacymanager.model;

public class User {
    private String email;
    private String name;
    private String role;
    private String password;
    private int phonenumber;


    public User(String email, String name, String role, String password, int phonenumber) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.password = password;
        this.phonenumber = phonenumber;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}
