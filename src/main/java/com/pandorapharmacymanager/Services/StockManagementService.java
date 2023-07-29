package com.pandorapharmacymanager.Services;

import com.pandorapharmacymanager.database.interfaces.DrugDAO;
import com.pandorapharmacymanager.model.Drug;

import java.sql.SQLException;
import java.util.List;

public class StockManagementService {
    private DrugDAO drugDAO; // Inject DrugDAO dependency
    private SalesService salesService; // Inject SalesService dependency
    private ExpirationService expirationService; // Inject ExpirationService dependency

    // Constructor Injection
    public StockManagementService(DrugDAO drugDAO, SalesService salesService, ExpirationService expirationService) {
        this.drugDAO = drugDAO;
        this.salesService = salesService;
        this.expirationService = expirationService;
    }

    // Method to determine optimal stock quantity for each drug
    public int determineOptimalStockQuantity(Drug drug) {
        double averageMonthlySales = salesService.getDrugSalesTotal(drug.getDrugId());
        int leadTimeInMonths = 2;

        // Custom algorithm 1: Adjust optimal stock based on sales history
        if (averageMonthlySales > 100) {
            averageMonthlySales *= 1.2; // Increase optimal stock for high-demand drugs
        } else if (averageMonthlySales < 10) {
            averageMonthlySales *= 0.8; // Decrease optimal stock for low-demand drugs
        }


        int optimalStock = (int) (averageMonthlySales * leadTimeInMonths);


        // Ensure the optimal stock quantity is within the specified bounds (10 to 1000)
        optimalStock = Math.min(1000, Math.max(10, optimalStock));

        return optimalStock;
    }

    // Method to check and update stock levels for all drugs
    public void updateStockLevels() throws SQLException {
        List<Drug> drugs = drugDAO.getAllDrugs();
        for (Drug drug : drugs) {
            int currentStock = drug.getQuantityInStock();
            int optimalStock = determineOptimalStockQuantity(drug);

            if (currentStock < optimalStock) {
                int quantityToOrder = optimalStock - currentStock;
                // Implement logic to order stock from suppliers
                drug.setQuantityInStock(currentStock + quantityToOrder);
            } else if (currentStock > optimalStock) {
                // Implement logic to sell excess stock or reduce stock levels
                drug.setQuantityInStock(optimalStock);
            }

            drugDAO.updateDrug(drug);
        }
    }

    // Additional methods for stock level management can be added here
    // For example, methods to handle stock adjustments, expiration checks, etc.
}
