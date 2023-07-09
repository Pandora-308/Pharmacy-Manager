package com.pandorapharmacymanager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LogInController {
    public TextField emailfield;
    public Button loginbutton;
    public PasswordField passfield;
    public Button cancelbutton;
    public Label loginmessage;


    public void oncancelbuttonclick(ActionEvent actionEvent) {
        Stage loginStage = (Stage) cancelbutton.getScene().getWindow();
        loginStage.close();
    }

    public void onloginbuttonclick(ActionEvent actionEvent) {
        validator();

    }

    public void onenterkeypressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            validator();
        }
    }

    private void validator() {
        if(emailfield.getText().isBlank( ) && passfield.getText().isBlank()){
            loginmessage.setText("Please input a valid email and password");
            loginmessage.setTextFill(Color.valueOf("#F0483E"));
        }
        else if ( passfield.getText().isBlank()){
            loginmessage.setText("Input password");
            loginmessage.setTextFill(Color.valueOf("#F0483E"));
        }
        else if ( emailfield.getText().isBlank()){
            loginmessage.setText("Please input a valid email");
            loginmessage.setTextFill(Color.valueOf("#F0483E"));
        }
        else {
            loginmessage.setText("Login Successful;");
            loginmessage.setTextFill(Color.valueOf("#009535"));
        }
    }
}

