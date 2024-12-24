package ru.noleg.crmmm.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Student {
    private String surname;
    private String name;
    private String patronymic;
    private Parent parent;
    boolean isPaid;
}
