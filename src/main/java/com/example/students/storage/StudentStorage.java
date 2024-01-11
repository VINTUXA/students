package com.example.students.storage;

import com.example.students.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class StudentStorage {
    private Map<String, Student> students;
    @Autowired
    public StudentStorage(){
        this.students = new HashMap<>();
    }

    public void add(Student student){
        students.put(student.getId(), student);
    }

    public List<Student> list(){
        List<Student> studentList = new ArrayList<>();
        for (Map.Entry<String, Student> entry : students.entrySet()){
            studentList.add(entry.getValue());
        }
        return studentList;
    }

    public boolean delete(String id){
        if (!students.containsKey(id)){
            return false;
        } else {
            students.remove(id);
            return true;
        }
    }

    public void clean(){
        students.clear();
    }

    public Student getStudentById(String id){
        if (students.containsKey(id)){
            return students.get(id);
        } else {
            return null;
        }
    }
}
