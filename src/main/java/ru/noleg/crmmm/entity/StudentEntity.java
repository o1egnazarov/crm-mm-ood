package ru.noleg.crmmm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class StudentEntity {
    private String surname;
    private String name;
    private String patronymic;
    private ParentEntity parentEntity;
    boolean isPaid;
}
