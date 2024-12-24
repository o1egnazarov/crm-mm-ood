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
public class HeadTeacher {
    private String surname;
    private String name;
    private String patronymic;
    private List<Teacher> teachers;
}
