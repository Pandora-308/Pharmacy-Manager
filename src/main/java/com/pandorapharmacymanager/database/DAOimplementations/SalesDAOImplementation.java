package com.pandorapharmacymanager.database.DAOimplementations;

import com.pandorapharmacymanager.database.DatabaseConnector;
import com.pandorapharmacymanager.database.interfaces.SalesDAO;
import com.pandorapharmacymanager.model.Sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesDAOImplementation implements SalesDAO {

    private static final String INSERT_SALES_QUERY = "INSERT INTO sales (salesId, drugId, customerId, salesDate, amount, paymentType, location, employeeId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_SALES_FOR_DRUG_QUERY = "SELECT salesId, drugId, customerId, salesDate, amount, paymentType, location, employeeId FROM sales WHERE drugId = ?";
    private static final String SELECT_SALES_FOR_CUSTOMER_QUERY = "SELECT salesId, drugId, customerId, salesDate, amount, paymentType, location, employeeId FROM sales WHERE customerId = ?";
    private static final String SELECT_SALES_BY_DATE_RANGE_QUERY = "SELECT salesId, drugId, customerId, salesDate, amount, paymentType, location, employeeId FROM sales WHERE salesDate BETWEEN ? AND ?";
    private static final String SELECT_SALES_BY_AMOUNT_RANGE_QUERY = "SELECT salesId, drugId, customerId, salesDate, amount, paymentType, location, employeeId FROM sales WHERE amount BETWEEN ? AND ?";
    private static final String SELECT_SALES_BY_PAYMENT_TYPE_QUERY = "SELECT salesId, drugId, customerId, salesDate, amount, paymentType, location, employeeId FROM sales WHERE paymentType = ?";
    private static final String SELECT_SALES_BY_LOCATION_QUERY = "SELECT salesId, drugId, customerId, salesDate, amount, paymentType, location, employeeId FROM sales WHERE location = ?";
    private static final String SELECT_SALES_BY_EMPLOYEE_ID_QUERY = "SELECT salesId, drugId, customerId, salesDate, amount, paymentType, location, employeeId FROM sales WHERE employeeId = ?";

    @Override
    public void addSales(Sales sales) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SALES_QUERY)) {
            statement.setString(1, sales.getSalesId());
            statement.setString(2, sales.getDrugId());
            statement.setString(3, sales.getCustomerId());
            statement.setDate(4, new java.sql.Date(sales.getSalesDate().getTime()));
            statement.setDouble(5, sales.getAmount());
            statement.setString(6, sales.getPaymentType());
            statement.setString(7, sales.getLocation());
            statement.setString(8, sales.getEmployeeId());
            statement.executeUpdate();
        }
    }

    @Override
    public List<Sales> getSalesForDrug(String drugId) throws SQLException {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SALES_FOR_DRUG_QUERY)) {
            statement.setString(1, drugId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sales sales = extractSalesFromResultSet(resultSet);
                salesList.add(sales);
            }
        }
        return salesList;
    }

    @Override
    public List<Sales> getSalesForCustomer(String customerId) throws SQLException {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SALES_FOR_CUSTOMER_QUERY)) {
            statement.setString(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sales sales = extractSalesFromResultSet(resultSet);
                salesList.add(sales);
            }
        }
        return salesList;
    }

    @Override
    public List<Sales> getSalesByDateRange(Date startDate, Date endDate) throws SQLException {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SALES_BY_DATE_RANGE_QUERY)) {
            statement.setDate(1, new java.sql.Date(startDate.getTime()));
            statement.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sales sales = extractSalesFromResultSet(resultSet);
                salesList.add(sales);
            }
        }
        return salesList;
    }

    @Override
    public List<Sales> getSalesByAmountRange(double minAmount, double maxAmount) throws SQLException {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SALES_BY_AMOUNT_RANGE_QUERY)) {
            statement.setDouble(1, minAmount);
            statement.setDouble(2, maxAmount);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sales sales = extractSalesFromResultSet(resultSet);
                salesList.add(sales);
            }
        }
        return salesList;
    }

    @Override
    public List<Sales> getSalesByPaymentType(String paymentType) throws SQLException {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SALES_BY_PAYMENT_TYPE_QUERY)) {
            statement.setString(1, paymentType);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sales sales = extractSalesFromResultSet(resultSet);
                salesList.add(sales);
            }
        }
        return salesList;
    }

    @Override
    public List<Sales> getSalesByLocation(String location) throws SQLException {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SALES_BY_LOCATION_QUERY)) {
            statement.setString(1, location);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sales sales = extractSalesFromResultSet(resultSet);
                salesList.add(sales);
            }
        }
        return salesList;
    }

    @Override
    public List<Sales> getSalesByEmployeeId(String employeeId) throws SQLException {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SALES_BY_EMPLOYEE_ID_QUERY)) {
            statement.setString(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sales sales = extractSalesFromResultSet(resultSet);
                salesList.add(sales);
            }
        }
        return salesList;
    }

    // Helper method to extract Sales from ResultSet
    private Sales extractSalesFromResultSet(ResultSet resultSet) throws SQLException {
        String salesId = resultSet.getString("salesId");
        String drugId = resultSet.getString("drugId");
        String customerId = resultSet.getString("customerId");
        Date salesDate = resultSet.getDate("salesDate");
        double amount = resultSet.getDouble("amount");
        String paymentType = resultSet.getString("paymentType");
        String location = resultSet.getString("location");
        String employeeId = resultSet.getString("employeeId");

        return new Sales(salesId, drugId, customerId, salesDate, amount, paymentType, location, employeeId);
    }
}
