package com.example.students.event;

import com.example.students.model.Student;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHolderListener {
    @EventListener
    public void listen(EventHolder event){
        Student student = event.getStudent();
        if (event.getStudentEventType() == StudentEventType.ADD) {
            System.out.println(String.format("Student with id - %s, first name - %s, last name - %s, age - %s has been added!",
                    student.getId(), student.getFirstName(), student.getLastName(), student.getAge()));
        } else if (event.getStudentEventType() == StudentEventType.DELETE) {
            System.out.println(String.format("Student with id %s has been deleted!", student.getId()));
        }
    }
}
