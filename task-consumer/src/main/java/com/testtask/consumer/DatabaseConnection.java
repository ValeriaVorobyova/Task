package com.testtask.consumer;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection Connection() throws SQLException, IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/application.properties"));
        Connection connection = DriverManager.getConnection(properties.getProperty("db.url"),
                properties.getProperty("db.username"), properties.getProperty("db.password"));
        return connection;
    }
}
