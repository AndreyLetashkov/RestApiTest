package models;

import lombok.Data;

@Data
public class Person {
    String body;
    String title;
    int userId;
    int id;

    public Person(String body, String title, int userId) {
        this.body = body;
        this.title = title;
        this.userId = userId;
    }
}