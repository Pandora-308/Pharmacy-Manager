package com.pandorapharmacymanager.database.interfaces;

import com.pandorapharmacymanager.model.Sales;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface SalesDAO {
    void addSales(Sales sales) throws SQLException;
    List<Sales> getSalesForDrug(String drugId) throws SQLException;
    List<Sales> getSalesForCustomer(String customerId) throws SQLException;
    List<Sales> getSalesByDateRange(Date startDate, Date endDate) throws SQLException;
    List<Sales> getSalesByAmountRange(double minAmount, double maxAmount) throws SQLException;
    List<Sales> getSalesByPaymentType(String paymentType) throws SQLException;
    List<Sales> getSalesByLocation(String location) throws SQLException;
    List<Sales> getSalesByEmployeeId(String employeeId) throws SQLException;
    // Additional methods for searching, listing sales, etc.
}
