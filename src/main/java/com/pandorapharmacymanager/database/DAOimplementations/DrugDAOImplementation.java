package com.pandorapharmacymanager.database.DAOimplementations;

import com.pandorapharmacymanager.database.DatabaseConnector;
import com.pandorapharmacymanager.database.interfaces.DrugDAO;
import com.pandorapharmacymanager.model.Drug;
import com.pandorapharmacymanager.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugDAOImplementation implements DrugDAO {

    private static final String INSERT_DRUG_QUERY = "INSERT INTO drugs (drugId, drugName, genericName, dosageForm, strength, quantityInStock, supplierId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_DRUG_QUERY = "UPDATE drugs SET drugName = ?, genericName = ?, dosageForm = ?, strength = ?, quantityInStock = ?, supplierId = ? WHERE drugId = ?";
    private static final String DELETE_DRUG_QUERY = "DELETE FROM drugs WHERE drugId = ?";
    private static final String SELECT_DRUG_BY_ID_QUERY = "SELECT drugId, drugName, genericName, dosageForm, strength, quantityInStock, supplierId FROM drugs WHERE drugId = ?";
    private static final String SELECT_ALL_DRUGS_QUERY = "SELECT drugId, drugName, genericName, dosageForm, strength, quantityInStock, supplierId FROM drugs";

    @Override
    public void addDrug(Drug drug) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_DRUG_QUERY)) {
            statement.setString(1, drug.getDrugId());
            statement.setString(2, drug.getDrugName());
            statement.setString(3, drug.getGenericName());
            statement.setString(4, drug.getDosageForm());
            statement.setString(5, drug.getStrength());
            statement.setInt(6, drug.getQuantityInStock());
            statement.setString(7, drug.getSupplier().getSupplierId());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateDrug(Drug drug) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DRUG_QUERY)) {
            statement.setString(1, drug.getDrugName());
            statement.setString(2, drug.getGenericName());
            statement.setString(3, drug.getDosageForm());
            statement.setString(4, drug.getStrength());
            statement.setInt(5, drug.getQuantityInStock());
            statement.setString(6, drug.getSupplier().getSupplierId());
            statement.setString(7, drug.getDrugId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteDrug(String drugId) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_DRUG_QUERY)) {
            statement.setString(1, drugId);
            statement.executeUpdate();
        }
    }

    @Override
    public Drug getDrugById(String drugId) throws SQLException {
        Drug drug = null;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_DRUG_BY_ID_QUERY)) {
            statement.setString(1, drugId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                drug = extractDrugFromResultSet(resultSet);
            }
        }
        return drug;
    }

    @Override
    public List<Drug> getAllDrugs() throws SQLException {
        List<Drug> drugs = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DRUGS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Drug drug = extractDrugFromResultSet(resultSet);
                drugs.add(drug);
            }
        }
        return drugs;
    }

    @Override
    public List<Drug> getDrugsByGenericName(String genericName) throws SQLException {
        List<Drug> drugs = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM drugs WHERE genericName = ?")) {
            statement.setString(1, genericName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Drug drug = extractDrugFromResultSet(resultSet);
                drugs.add(drug);
            }
        }
        return drugs;
    }


    // Helper method to extract Drug from ResultSet
    private Drug extractDrugFromResultSet(ResultSet resultSet) throws SQLException {
        String drugId = resultSet.getString("drugId");
        String drugName = resultSet.getString("drugName");
        String genericName = resultSet.getString("genericName");
        String dosageForm = resultSet.getString("dosageForm");
        String strength = resultSet.getString("strength");
        int quantityInStock = resultSet.getInt("quantityInStock");
        String supplierId = resultSet.getString("supplierId");

        // Assuming you have a Supplier class for creating suppliers
        Supplier supplier = new Supplier(supplierId); // You can initialize the Supplier object with the supplierId

        return new Drug(drugId, drugName, genericName, dosageForm, strength, quantityInStock, supplier);
    }
}
