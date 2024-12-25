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
public class HeadTeacherEntity {
    private String surname;
    private String name;
    private String patronymic;
    private List<TeacherEntity> teacherEntities;
}
