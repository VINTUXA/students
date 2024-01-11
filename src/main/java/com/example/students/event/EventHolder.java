package com.example.students.event;

import com.example.students.model.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EventHolder extends ApplicationEvent {
    private final Student student;
    private StudentEventType studentEventType;

    public EventHolder(Object source, Student student, StudentEventType studentEventType) {
        super(source);
        this.student = student;
        this.studentEventType = studentEventType;
    }
}
