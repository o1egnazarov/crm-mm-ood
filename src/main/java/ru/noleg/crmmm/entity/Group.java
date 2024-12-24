package ru.noleg.crmmm.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Group {
    private String title;
    private List<Student> students;
    private List<Lesson> schedule;

    public List<Lesson> addClassToSchedule(Lesson lesson) {
        this.schedule.add(lesson);
        return schedule;
    }
}


