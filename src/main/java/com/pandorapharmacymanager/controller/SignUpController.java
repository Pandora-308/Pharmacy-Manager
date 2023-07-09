package com.pandorapharmacymanager.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class SignUpController {
    public ChoiceBox<String> selectrole;
    @FXML
    public void initialize() {
        selectrole.getItems().addAll("Pharmacist", "Administrator", "Manager","Select role");
        selectrole.getSelectionModel().select("Select Role");

    }
}
