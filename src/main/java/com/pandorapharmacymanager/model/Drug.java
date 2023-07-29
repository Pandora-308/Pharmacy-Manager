package com.pandorapharmacymanager.model;

import java.time.LocalDate;

public class Drug {
    private String drugId;
    private String drugName;
    private String genericName;
    private String dosageForm;
    private String strength;
    private int quantityInStock;
    private Supplier supplier;
    private LocalDate expirationDate;

    public Drug(String drugId, String drugName, String genericName, String dosageForm, String strength, int quantityInStock, Supplier supplier) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.genericName = genericName;
        this.dosageForm = dosageForm;
        this.strength = strength;
        this.quantityInStock = quantityInStock;
        this.supplier = supplier;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
