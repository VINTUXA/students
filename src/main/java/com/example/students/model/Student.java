package com.example.students.model;
import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    public Student(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = UUID.randomUUID().toString();
    }
}
