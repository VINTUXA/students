package com.example.students.shell;


import com.example.students.model.Student;
import com.example.students.service.StudentService;
import com.example.students.storage.StudentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.*;

import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class StudentShell {
    @Autowired
    StudentService studentService;

    @ShellMethod(key = "add")
    private void add(@ShellOption(value = "f") String firstName,
                       @ShellOption(value = "l") String lastName) {
        Student student = new Student(firstName, lastName);
        studentService.add(student);
    }

    @ShellMethod
    private List<Student> list(){
        return studentService.list();
    }

    @ShellMethod
    private void delete(@ShellOption(value = "id") String id){
        studentService.delete(id);
    }

    @ShellMethod
    private String clean(){
        studentService.clean();
        return "All students have been removed!";
    }

}
