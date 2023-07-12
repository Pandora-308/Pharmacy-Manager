package com.pandorapharmacymanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//implement code to connect to mysql connector database
public class DatabaseConnector {
    private static String url = "jdbc:mysql://localhost:3306/pharmacy";
    private static String user = "root";
    private static  String password = "Codeman.6192";

    private DatabaseConnector(){

    }

    public  static Connection getConnection() throws SQLException{
        Connection connection = null;
        connection = DriverManager.getConnection(url,user,password);
        return connection;
    }
}
