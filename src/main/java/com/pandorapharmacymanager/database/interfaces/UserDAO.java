package com.pandorapharmacymanager.database.interfaces;


import com.pandorapharmacymanager.model.User;

import java.sql.SQLException;

public interface UserDAO  {


    void updateUser(User user) throws SQLException;
    void addUser(User user)throws SQLException;
    void editUser(String email, String name, String role, String password, String phoneNumber)throws SQLException;
    String getEmail(String email)throws SQLException;
    String getPassword(String email)throws SQLException;
    String getName(String name) throws SQLException;
    String getRole(String role) throws SQLException;

    int getPhonenumber(String phonenumber) throws SQLException;
    boolean isAuthenticated(String email, String password) throws SQLException;

}
