package com.pandorapharmacymanager.database.interfaces;

import com.pandorapharmacymanager.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer customer) throws SQLException;
    void updateCustomer(Customer customer) throws SQLException;
    void deleteCustomer(String customerId) throws SQLException;
    Customer getCustomerById(String customerId) throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;
}
