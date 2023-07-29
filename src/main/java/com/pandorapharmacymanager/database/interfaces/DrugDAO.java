package com.pandorapharmacymanager.database.interfaces;

import com.pandorapharmacymanager.model.Drug;

import java.sql.SQLException;
import java.util.List;

public interface DrugDAO {
    void addDrug(Drug drug) throws SQLException;
    void updateDrug(Drug drug) throws SQLException;
    void deleteDrug(String drugId) throws SQLException;
    Drug getDrugById(String drugId) throws SQLException;
    List<Drug> getAllDrugs() throws SQLException;

    List<Drug> getDrugsByGenericName(String genericName) throws SQLException;
}
