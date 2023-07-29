package com.pandorapharmacymanager.Services;

import com.pandorapharmacymanager.model.Supplier;

import java.util.HashMap;
import java.util.Map;

public class SupplierService {
    private Map<String, Supplier> supplierMap;

    public SupplierService() {
        supplierMap = new HashMap<>();
    }

    public void addSupplier(Supplier supplier) {
        supplierMap.put(supplier.getSupplierId(), supplier);
    }

    public Supplier getSupplierById(String supplierId) {
        return supplierMap.get(supplierId);
    }


}
