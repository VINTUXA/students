package com.example.students.event;

import com.example.students.model.Student;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHolderListener {
    @EventListener
    public void listen(EventHolder event){
        Student student = event.getStudent();
        if (event.getEventType() == EventType.ADD) {
            String.format("Student with id - %s, first name - %s, last name - %s has been added!",
                    student.getId(), student.getFirstName(), student.getLastName());
        } else if (event.getEventType() == EventType.DELETE) {
            String.format("Student with id %s has been deleted!", student.getId());
        }
    }
}
