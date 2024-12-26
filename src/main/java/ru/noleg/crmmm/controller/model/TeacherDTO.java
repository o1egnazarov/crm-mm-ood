package ru.noleg.crmmm.controller.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ru.noleg.crmmm.messages.GeneralMessages;
import ru.noleg.crmmm.messages.TeacherMessages;


public class TeacherDTO {

    @NotBlank(message = GeneralMessages.NOT_BLANK_SURNAME)
    @Size(min = 1, max = 25)
    private String surname;

    @NotBlank(message = GeneralMessages.NOT_BLANK_NAME)
    @Size(min = 1, max = 25)
    private String name;

    @Size(min = 1, max = 25)
    private String patronymic;


    public TeacherDTO() {
    }

    public TeacherDTO(String surname,
                      String name,
                      String patronymic
    ) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
