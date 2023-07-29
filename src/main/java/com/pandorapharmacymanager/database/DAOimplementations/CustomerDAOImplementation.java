package com.pandorapharmacymanager.database.DAOimplementations;

import com.pandorapharmacymanager.database.DatabaseConnector;
import com.pandorapharmacymanager.database.interfaces.CustomerDAO;
import com.pandorapharmacymanager.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImplementation implements CustomerDAO {

    private static final String INSERT_CUSTOMER_QUERY = "INSERT INTO customers (customerId, name, email, phone) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER_QUERY = "UPDATE customers SET name = ?, email = ?, phone = ? WHERE customerId = ?";
    private static final String DELETE_CUSTOMER_QUERY = "DELETE FROM customers WHERE customerId = ?";
    private static final String SELECT_CUSTOMER_BY_ID_QUERY = "SELECT customerId, name, email, phone FROM customers WHERE customerId = ?";
    private static final String SELECT_ALL_CUSTOMERS_QUERY = "SELECT customerId, name, email, phone FROM customers";

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER_QUERY)) {
            statement.setString(1, customer.getCustomerId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_QUERY)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhone());
            statement.setString(4, customer.getCustomerId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteCustomer(String customerId) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_QUERY)) {
            statement.setString(1, customerId);
            statement.executeUpdate();
        }
    }

    @Override
    public Customer getCustomerById(String customerId) throws SQLException {
        Customer customer = null;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID_QUERY)) {
            statement.setString(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                customer = extractCustomerFromResultSet(resultSet);
            }
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = extractCustomerFromResultSet(resultSet);
                customers.add(customer);
            }
        }
        return customers;
    }

    // Helper method to extract Customer from ResultSet
    private Customer extractCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        String customerId = resultSet.getString("customerId");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        return new Customer(customerId, name, email, phone);
    }
}
