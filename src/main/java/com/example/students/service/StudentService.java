package com.example.students.service;

import com.example.students.model.Student;

import java.util.List;

public interface StudentService {
    public void add(Student student);
    public List<Student> list();
    public boolean delete(String id);
    public void clean();

}
