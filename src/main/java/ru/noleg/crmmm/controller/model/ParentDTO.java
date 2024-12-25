package ru.noleg.crmmm.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ParentDTO {
    private String surname;
    private String name;
    private String patronymic;
    private String email;
}
