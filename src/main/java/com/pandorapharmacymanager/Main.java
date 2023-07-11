package com.pandorapharmacymanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        FXMLLoader signupfxmlloader = new FXMLLoader(Main.class.getResource("SignUp.fxml"));

        Scene loginscene = new Scene(loginfxmlLoader.load(), 620, 480);
        Scene signupscene = new Scene(signupfxmlloader.load());

        resizable(primarystage,signupscene);

    }

    public void resizable(Stage primarystage,Scene scene){
        primarystage.setResizable(true);
        primarystage.setScene(scene);
        primarystage.show();
    }

    public void nonresizable(Stage primarystage,Scene scene){
        primarystage.initStyle(StageStyle.UNDECORATED);
        primarystage.setResizable(false);
        primarystage.setScene(scene);
        primarystage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}