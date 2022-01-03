package com.testtask.controller;

import com.testtask.model.Message;
import com.testtask.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class HomeController {

    @Autowired
    private static ProducerService producerService = new ProducerService();

    public static void main(String[] args) throws SQLException, IOException {
        Statement statement = DatabaseConnection.Connection().createStatement();
        String query = "SELECT * FROM table1";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String message = resultSet.getString(2);
            String age = resultSet.getString(3);
            Message message1 = new Message(message,age);
            producerService.produce(message1);
            System.out.println(message1);
        }
        resultSet.close();
        statement.close();
    }


}
