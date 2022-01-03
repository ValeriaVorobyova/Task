package com.testtask.consumer;

import com.testtask.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class ConsumerService {

    @KafkaListener(topics = "messages", groupId = "message_group_id")
    public void consume(Message message) throws SQLException, IOException {
        //место вывода записать
        String insert = "INSERT INTO " + "table1" + "(" + "Name" + "," + "Timestamp" + ")" + "VALUES(?,?)";
        PreparedStatement prST = DatabaseConnection.Connection().prepareStatement(insert);
        prST.setString(1, message.getMessage());
        prST.setString(2, message.getAge());
        prST.executeUpdate();
        System.out.println("Consuming the message: " + message);
    }

}
