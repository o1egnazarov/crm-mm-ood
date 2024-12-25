package ru.noleg.crmmm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class GroupEntity {
    private String title;
    private List<StudentEntity> studentEntities;
    private List<LessonEntity> schedule;

    public List<LessonEntity> addClassToSchedule(LessonEntity lessonEntity) {
        this.schedule.add(lessonEntity);
        return schedule;
    }
}


