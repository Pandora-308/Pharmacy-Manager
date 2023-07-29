package com.pandorapharmacymanager.model;

import java.util.Date;

public class PurchaseHistory {
    private String drugId;
    private Date purchaseDate;
    private double totalAmount;

    public PurchaseHistory(String drugId, Date purchaseDate, double totalAmount) {
        this.drugId = drugId;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
