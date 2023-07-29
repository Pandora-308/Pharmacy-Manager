package com.pandorapharmacymanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene loginscene = new Scene(loginfxmlLoader.load(), 620, 480);
        nonresizable(primarystage,loginscene);

    }

    public void nonresizable(Stage primarystage,Scene scene){
        primarystage.setResizable(false);
        primarystage.setScene(scene);
        primarystage.show();
    }


    public static void main(String[] args)  {
        launch();
    }

}