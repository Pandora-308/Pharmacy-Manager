package com.pandorapharmacymanager.Services;

import java.util.HashMap;
import java.util.Map;

public class SalesService {
    private Map<String, Double> drugSalesMap;

    public SalesService() {
        drugSalesMap = new HashMap<>();
    }

    public void addDrugSale(String drugCode, double amount) {
        if (drugSalesMap.containsKey(drugCode)) {
            double totalAmount = drugSalesMap.get(drugCode);
            totalAmount += amount;
            drugSalesMap.put(drugCode, totalAmount);
        } else {
            drugSalesMap.put(drugCode, amount);
        }
    }

    public double getDrugSalesTotal(String drugCode) {
        return drugSalesMap.getOrDefault(drugCode, 0.0);
    }
}
