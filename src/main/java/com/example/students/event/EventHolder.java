package com.example.students.event;

import com.example.students.model.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EventHolder extends ApplicationEvent {
    private final Student student;
    private EventType eventType;

    public EventHolder(Object source, Student student, EventType eventType) {
        super(source);
        this.student = student;
    }
}
