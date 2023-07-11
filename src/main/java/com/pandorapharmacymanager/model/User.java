package com.pandorapharmacymanager.model;

public class User {
    private String id;
    private String surname;
    private String othernames;
    private String role;
    private int phonenumber;
    private String password;

    public User(String id, String surname, String othernames, String role, int phonenumber, String password) {
        this.id = id;
        this.surname = surname;
        this.othernames = othernames;
        this.role = role;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOthernames() {
        return othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
