package com.pandorapharmacymanager.Services;

import com.pandorapharmacymanager.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private Map<String, Customer> customerMap;

    public CustomerService() {
        customerMap = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
    }

    public Customer getCustomerById(String customerId) {
        return customerMap.get(customerId);
    }

}
