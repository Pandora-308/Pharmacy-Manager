package com.pandorapharmacymanager.model;

import java.util.Date;

public class Sales {
    private String salesId;
    private String drugId;
    private String customerId;
    private Date salesDate;
    private double amount;
    private String paymentType;
    private String location;
    private String employeeId;

    public Sales(String salesId, String drugId, String customerId, Date salesDate, double amount, String paymentType, String location, String employeeId) {
        this.salesId = salesId;
        this.drugId = drugId;
        this.customerId = customerId;
        this.salesDate = salesDate;
        this.amount = amount;
        this.paymentType = paymentType;
        this.location = location;
        this.employeeId = employeeId;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
