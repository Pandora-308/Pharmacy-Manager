package com.pandorapharmacymanager.database.DAOimplementations;

import com.pandorapharmacymanager.database.DatabaseConnector;
import com.pandorapharmacymanager.database.interfaces.PurchaseHistoryDAO;
import com.pandorapharmacymanager.model.PurchaseHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseHistoryDAOImplementation implements PurchaseHistoryDAO {

    private static final String INSERT_PURCHASE_HISTORY_QUERY = "INSERT INTO purchase_history (drugId, purchaseDate, totalAmount) VALUES (?, ?, ?)";
    private static final String SELECT_PURCHASE_HISTORY_FOR_DRUG_QUERY = "SELECT drugId, purchaseDate, totalAmount FROM purchase_history WHERE drugId = ?";

    @Override
    public void addPurchaseHistory(PurchaseHistory purchaseHistory) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PURCHASE_HISTORY_QUERY)) {
            statement.setString(1, purchaseHistory.getDrugId());
            statement.setDate(2, new java.sql.Date(purchaseHistory.getPurchaseDate().getTime()));
            statement.setDouble(3, purchaseHistory.getTotalAmount());
            statement.executeUpdate();
        }
    }

    @Override
    public List<PurchaseHistory> getPurchaseHistoryForDrug(String drugId) throws SQLException {
        List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_PURCHASE_HISTORY_FOR_DRUG_QUERY)) {
            statement.setString(1, drugId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PurchaseHistory purchaseHistory = extractPurchaseHistoryFromResultSet(resultSet);
                purchaseHistoryList.add(purchaseHistory);
            }
        }
        return purchaseHistoryList;
    }

    // Helper method to extract PurchaseHistory from ResultSet
    private PurchaseHistory extractPurchaseHistoryFromResultSet(ResultSet resultSet) throws SQLException {
        String drugId = resultSet.getString("drugId");
        Date purchaseDate = resultSet.getDate("purchaseDate");
        double totalAmount = resultSet.getDouble("totalAmount");

        return new PurchaseHistory(drugId, purchaseDate, totalAmount);
    }
}
