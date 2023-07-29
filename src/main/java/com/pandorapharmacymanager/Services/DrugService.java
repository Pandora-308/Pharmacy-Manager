package com.pandorapharmacymanager.Services;

import com.pandorapharmacymanager.database.interfaces.DrugDAO;
import com.pandorapharmacymanager.model.Drug;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class DrugService {
    private DrugDAO drugDAO; // Inject DrugDAO dependency

    // Constructor Injection
    public DrugService(DrugDAO drugDAO) {
        this.drugDAO = drugDAO;
    }

    public List<Drug> getAllDrugs() throws SQLException {
        return drugDAO.getAllDrugs();
    }

    // Utilizing Iterators
    public void printAllDrugNames() throws SQLException {
        List<Drug> drugs = drugDAO.getAllDrugs();
        Iterator<Drug> iterator = drugs.iterator();
        while (iterator.hasNext()) {
            Drug drug = iterator.next();
            System.out.println(drug.getDrugName());
        }
    }

    // Utilizing Recursion
    public void printDrugsRecursively(List<Drug> drugs) {
        printDrugsRecursivelyHelper(drugs, 0);
    }

    private void printDrugsRecursivelyHelper(List<Drug> drugs, int index) {
        if (index >= drugs.size()) {
            return;
        }

        Drug drug = drugs.get(index);
        System.out.println(drug.getDrugName());

        printDrugsRecursivelyHelper(drugs, index + 1);
    }

    // Utilizing Stacks
    public void printDrugsUsingStack() throws SQLException {
        List<Drug> drugs = drugDAO.getAllDrugs();
        Stack<Drug> drugStack = new Stack<>();

        for (Drug drug : drugs) {
            drugStack.push(drug);
        }

        while (!drugStack.isEmpty()) {
            Drug drug = drugStack.pop();
            System.out.println(drug.getDrugName());
        }
    }

    // Utilizing Queues
    public void printDrugsUsingQueue() throws SQLException {
        List<Drug> drugs = drugDAO.getAllDrugs();
        Queue<Drug> drugQueue = new LinkedList<>();

        for (Drug drug : drugs) {
            drugQueue.offer(drug);
        }

        while (!drugQueue.isEmpty()) {
            Drug drug = drugQueue.poll();
            System.out.println(drug.getDrugName());
        }
    }
}
