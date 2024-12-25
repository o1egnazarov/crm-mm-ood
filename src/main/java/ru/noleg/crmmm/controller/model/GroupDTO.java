package ru.noleg.crmmm.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.noleg.crmmm.entity.LessonEntity;
import ru.noleg.crmmm.entity.StudentEntity;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GroupDTO {
    private String title;
    private List<StudentEntity> studentEntities;
    private List<LessonEntity> schedule;
}
