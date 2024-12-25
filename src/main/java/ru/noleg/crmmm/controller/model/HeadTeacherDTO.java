package ru.noleg.crmmm.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class HeadTeacherDTO {
    private String surname;
    private String name;
    private String patronymic;
    private List<TeacherDTO> teacherEntities;
}
