package com.example.students.storage;

import com.example.students.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
@ConditionalOnProperty("app.student-initializer.enabled")
public class StudentInitializer {

    @Autowired
    StudentStorage studentStorage;

    @Value("${initial.students.file.path}")
    private String initialStudentFileFilePath;


    @PostConstruct
    public void init(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(initialStudentFileFilePath));
            String line;
            while ((line = reader.readLine()) != null){
                String[] contactData = line.split(";");
                Student student = new Student(contactData[0],contactData[1]);
                studentStorage.add(student);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
