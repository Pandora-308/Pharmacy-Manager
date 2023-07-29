package com.pandorapharmacymanager.model;

public class Supplier {
    private String supplierId;
    private String supplierName;
    private String location;
    // Additional fields as per the requirements

    public Supplier(String supplierId, String supplierName, String location) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.location = location;
    }

    public Supplier(String supplierId) {

        this.supplierId = supplierId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
