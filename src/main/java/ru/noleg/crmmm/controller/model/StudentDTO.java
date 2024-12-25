package ru.noleg.crmmm.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.noleg.crmmm.entity.ParentEntity;


@Getter
@Builder
@AllArgsConstructor
public class StudentDTO {
    private String surname;
    private String name;
    private String patronymic;
    private ParentEntity parentEntity;
//    boolean isPaid;
}
