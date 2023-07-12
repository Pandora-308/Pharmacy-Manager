package com.pandorapharmacymanager.database.DAOimplementations;


import com.pandorapharmacymanager.database.DatabaseConnector;
import com.pandorapharmacymanager.database.interfaces.UserDAO;
import com.pandorapharmacymanager.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImplementation implements UserDAO {
    private static final String UPDATE_USER_QUERY = "UPDATE user SET name = ?, role = ?, password = ?, phonenumber = ? WHERE email = ?";
    private static final String INSERT_USER_QUERY = "INSERT INTO user (email, name, role, password, phonenumber) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_EMAIL_QUERY = "SELECT email FROM user WHERE email = ?";
    private static final String SELECT_PASSWORD_QUERY = "SELECT password FROM user WHERE email = ?";
    private static final String SELECT_NAME_QUERY = "SELECT name FROM user WHERE name = ?";
    private static final String SELECT_ROLE_QUERY = "SELECT role FROM user WHERE role = ?";
    private static final String SELECT_PHONE_NUMBER_QUERY = "SELECT phonenumber FROM user WHERE phonenumber = ?";

    @Override
    public void updateUser(User user) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getRole());
            statement.setString(3, user.getPassword());
            statement.setString(4, String.valueOf(user.getPhonenumber()));
            statement.setString(5, user.getEmail());
            statement.executeUpdate();
        }
    }

    @Override
    public void addUser(User user) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.setString(3, user.getRole());
            statement.setString(4, user.getPassword());
            statement.setString(5, String.valueOf(user.getPhonenumber()));
            statement.executeUpdate();
        }
    }

    @Override
    public void editUser(String email, String name, String role, String password, String phoneNumber) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY)) {
            statement.setString(1, name);
            statement.setString(2, role);
            statement.setString(3, password);
            statement.setString(4, phoneNumber);
            statement.setString(5, email);
            statement.executeUpdate();
        }
    }

    @Override
    public String getEmail(String email) throws SQLException {
        String userEmail = null;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_EMAIL_QUERY)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userEmail = resultSet.getString("email");
            }
        }
        return userEmail;
    }

    @Override
    public String getPassword(String email) throws SQLException {
        String userPassword = null;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_PASSWORD_QUERY)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userPassword = resultSet.getString("password");
            }
        }
        return userPassword;
    }

    @Override
    public String getName(String name) throws SQLException {
        String userName = null;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_NAME_QUERY)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userName = resultSet.getString("name");
            }
        }
        return userName;
    }

    @Override
    public String getRole(String role) throws SQLException {
        String userRole = null;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ROLE_QUERY)) {
            statement.setString(1, role);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userRole = resultSet.getString("role");
            }
        }
        return userRole;
    }

    @Override
    public int getPhonenumber(String phonenumber) throws SQLException {
        int userPhoneNumber = 0;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_PHONE_NUMBER_QUERY)) {
            statement.setString(1, phonenumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userPhoneNumber = resultSet.getInt("phonenumber");
            }
        }
        return userPhoneNumber;
    }

    @Override
    public boolean isAuthenticated(String email, String password) throws SQLException {
        String storedPassword = getPassword(email);
        return storedPassword != null && storedPassword.equals(password);
    }
}