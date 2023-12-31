package com.pandorapharmacymanager.controller;

import com.pandorapharmacymanager.Main;
import com.pandorapharmacymanager.database.DAOimplementations.UserDAOImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LogInController {
    public Button createaccount;
    UserDAOImplementation userDAOImplementation = new UserDAOImplementation();
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

    private void validator()  {
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
            // Call the authenticateUser method from the UserDAOImplementation
            boolean isAuthenticated;
            try {
                isAuthenticated = userDAOImplementation.isAuthenticated(emailfield.getText(), passfield.getText());
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }

            if (isAuthenticated) {
                // Change login message and perform further actions for successful authentication
                loginmessage.setText("Login successful!");
                loginmessage.setTextFill(Color.valueOf("#008000"));
                // Perform additional actions for successful authentication, such as opening a new window
            } else {
                loginmessage.setText("Invalid email or password");
                loginmessage.setTextFill(Color.valueOf("#F0483E"));
            }
        }
    }


    public void oncreateaccountbuttonclick(ActionEvent actionEvent) {
            // Load the sign-up stage
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("signup.fxml"));
            try {
                Parent root = loader.load();
                Stage signUpStage = new Stage();
                signUpStage.setScene(new Scene(root));
                signUpStage.show();

                // Close the login stage
                Stage loginStage = (Stage) loginbutton.getScene().getWindow();
                loginStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}

