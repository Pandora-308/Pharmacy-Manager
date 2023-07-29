package com.pandorapharmacymanager.database.interfaces;

import com.pandorapharmacymanager.model.PurchaseHistory;

import java.sql.SQLException;
import java.util.List;

public interface PurchaseHistoryDAO {
    void addPurchaseHistory(PurchaseHistory purchaseHistory) throws SQLException;
    List<PurchaseHistory> getPurchaseHistoryForDrug(String drugId) throws SQLException;
}
