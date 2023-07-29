package com.pandorapharmacymanager.database.DAOimplementations;

import com.pandorapharmacymanager.database.DatabaseConnector;
import com.pandorapharmacymanager.database.interfaces.SupplierDAO;
import com.pandorapharmacymanager.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImplementation implements SupplierDAO {

    private static final String INSERT_SUPPLIER_QUERY = "INSERT INTO supplier (supplierId, supplierName, location) VALUES (?, ?, ?)";
    private static final String UPDATE_SUPPLIER_QUERY = "UPDATE supplier SET supplierName = ?, location = ? WHERE supplierId = ?";
    private static final String DELETE_SUPPLIER_QUERY = "DELETE FROM supplier WHERE supplierId = ?";
    private static final String SELECT_SUPPLIER_BY_ID_QUERY = "SELECT supplierId, supplierName, location FROM supplier WHERE supplierId = ?";
    private static final String SELECT_ALL_SUPPLIERS_QUERY = "SELECT supplierId, supplierName, location FROM supplier";

    @Override
    public void addSupplier(Supplier supplier) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SUPPLIER_QUERY)) {
            statement.setString(1, supplier.getSupplierId());
            statement.setString(2, supplier.getSupplierName());
            statement.setString(3, supplier.getLocation());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SUPPLIER_QUERY)) {
            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getLocation());
            statement.setString(3, supplier.getSupplierId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteSupplier(String supplierId) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SUPPLIER_QUERY)) {
            statement.setString(1, supplierId);
            statement.executeUpdate();
        }
    }

    @Override
    public Supplier getSupplierById(String supplierId) throws SQLException {
        Supplier supplier = null;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SUPPLIER_BY_ID_QUERY)) {
            statement.setString(1, supplierId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                supplier = extractSupplierFromResultSet(resultSet);
            }
        }
        return supplier;
    }

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        List<Supplier> supplierList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SUPPLIERS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Supplier supplier = extractSupplierFromResultSet(resultSet);
                supplierList.add(supplier);
            }
        }
        return supplierList;
    }

    // Helper method to extract Supplier from ResultSet
    private Supplier extractSupplierFromResultSet(ResultSet resultSet) throws SQLException {
        String supplierId = resultSet.getString("supplierId");
        String supplierName = resultSet.getString("supplierName");
        String location = resultSet.getString("location");

        return new Supplier(supplierId, supplierName, location);
    }
}
