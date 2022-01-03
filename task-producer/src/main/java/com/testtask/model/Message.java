package com.testtask.model;

public class Message {

    String message;
    String age;

    public Message(String message, String age) {
        this.message = message;
        this.age = age;
    }

    public Message() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", age=" + age +
                '}';
    }
}
