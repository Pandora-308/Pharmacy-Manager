package com.pandorapharmacymanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class SignUpController {
    public ChoiceBox<String> selectrole;
    public TextField surnamefield;
    public TextField emailfield;
    public PasswordField passfield;
    public PasswordField fassfield;
    public TextField othernamesfield;
    public TextField phonenumberfield;
    public Label createaccountmessage;

    @FXML
    public void initialize() {
        selectrole.getItems().addAll("Pharmacist", "Administrator", "Manager","Select role");
        selectrole.getSelectionModel().select("Select Role");

    }

    public void onenterkeypressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
        validator();
        }
    }

    public void oncreateaccountclicked(ActionEvent actionEvent) {
    }

    public void oncancelclicked(ActionEvent actionEvent) {
    }

    private void validator() {
        if(emailfield.getText().isBlank( ) && passfield.getText().isBlank()){
            createaccountmessage.setText("Please input a valid email and password");
            createaccountmessage.setTextFill(Color.valueOf("#F0483E"));
        }
        else if ( passfield.getText().isBlank()){
            createaccountmessage.setText("Input password");
            createaccountmessage.setTextFill(Color.valueOf("#F0483E"));
        }
        else if ( emailfield.getText().isBlank()){
            createaccountmessage.setText("Please input a valid email");
            createaccountmessage.setTextFill(Color.valueOf("#F0483E"));
        }
        else {
            createaccountmessage.setText("Login Successful;");
            createaccountmessage.setTextFill(Color.valueOf("#009535"));
        }
    }
}
