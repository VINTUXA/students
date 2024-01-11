package com.example.students.service;

import com.example.students.event.EventHolder;
import com.example.students.event.EventType;
import com.example.students.model.Student;
import com.example.students.storage.StudentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final ApplicationEventPublisher publisher;
    @Autowired
    StudentStorage studentStorage;

    @Autowired
    public StudentServiceImpl(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void add(Student student) {
        studentStorage.add(student);
        publisher.publishEvent(new EventHolder(this, student, EventType.ADD));
    }

    @Override
    public List<Student> list() {
        return studentStorage.list();
    }

    @Override
    public boolean delete(String id) {
        try{
            publisher.publishEvent(new EventHolder(this, studentStorage.getStudentById(id), EventType.ADD));
        } catch (NullPointerException e){
            System.out.println(e);
        }
        return studentStorage.delete(id);
    }

    @Override
    public void clean() {
        studentStorage.clean();
    }
}
