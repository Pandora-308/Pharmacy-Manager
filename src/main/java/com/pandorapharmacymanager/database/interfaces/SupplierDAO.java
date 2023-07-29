package com.pandorapharmacymanager.database.interfaces;

import com.pandorapharmacymanager.model.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO {
    void addSupplier(Supplier supplier) throws SQLException;
    void updateSupplier(Supplier supplier) throws SQLException;
    void deleteSupplier(String supplierId) throws SQLException;
    Supplier getSupplierById(String supplierId) throws SQLException;
    List<Supplier> getAllSuppliers() throws SQLException;
}
