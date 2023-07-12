package com.pandorapharmacymanager.controller;

import com.pandorapharmacymanager.database.DAOimplementations.UserDAOImplementation;
import com.pandorapharmacymanager.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

public class SignUpController {
    public Button cancelbutton;
    public Button creataccount;
    UserDAOImplementation userDAOImplementation = new UserDAOImplementation();
    public ChoiceBox<String> selectrole;
    public TextField emailfield;
    public PasswordField passfield;
    public TextField phonenumberfield;
    public Label createaccountmessage;
    public TextField namefield;

    @FXML
    public void initialize() {
        selectrole.getItems().addAll("Pharmacist", "Administrator", "Manager","Select role");
        selectrole.getSelectionModel().select("Select Role");

    }

    public void onenterkeypressed(KeyEvent keyEvent) {

    }

    public void oncreateaccountclicked(ActionEvent actionEvent) throws SQLException {
        String selectedRole = selectrole.getValue();
        String email = emailfield.getText();
        String password = passfield.getText();
        String phoneNumber = phonenumberfield.getText();
        String name = namefield.getText();

        User user = new User(email,name,selectedRole,password,phoneNumber);
        userDAOImplementation.addUser(user);
        createaccountmessage.setText("Account created successfully");
    }

    public void oncancelclicked(ActionEvent actionEvent) {
        Stage signupstage = (Stage) cancelbutton.getScene().getWindow();
        signupstage.close();
    }


}
