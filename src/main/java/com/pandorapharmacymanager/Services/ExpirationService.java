package com.pandorapharmacymanager.Services;

import com.pandorapharmacymanager.database.interfaces.DrugDAO;
import com.pandorapharmacymanager.model.Drug;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpirationService {
    private DrugDAO drugDAO; // Inject DrugDAO dependency

    // Constructor Injection
    public ExpirationService(DrugDAO drugDAO) {
        this.drugDAO = drugDAO;
    }

    // Method to check for expired drugs
    public List<Drug> getExpiredDrugs() throws SQLException {
        List<Drug> allDrugs = drugDAO.getAllDrugs();
        List<Drug> expiredDrugs = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();

        for (Drug drug : allDrugs) {
            LocalDate expirationDate = drug.getExpirationDate();
            if (expirationDate != null && expirationDate.isBefore(currentDate)) {
                expiredDrugs.add(drug);
            }
        }

        return expiredDrugs;
    }

    // Method to get the quantity of drugs that are near expiry
    public int getNearExpiryStock(String drugCode) throws SQLException {
        List<Drug> allDrugs = drugDAO.getAllDrugs();
        int nearExpiryStock = 0;

        LocalDate currentDate = LocalDate.now();
        LocalDate nearExpiryDate = currentDate.plusMonths(3); // Consider drugs within the next 3 months as near expiry

        for (Drug drug : allDrugs) {
            LocalDate expirationDate = drug.getExpirationDate();
            if (expirationDate != null && expirationDate.isBefore(nearExpiryDate)) {
                nearExpiryStock += drug.getQuantityInStock();
            }
        }

        return nearExpiryStock;
    }

}
