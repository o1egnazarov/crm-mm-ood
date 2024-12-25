package ru.noleg.crmmm.controller.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ru.noleg.crmmm.messages.GeneralMessages;
import ru.noleg.crmmm.messages.TeacherMessages;

public class StudentDTO {

    @NotBlank(message = GeneralMessages.NOT_BLANK_SURNAME)
    @Size(min = 1, max = 25)
    private String surname;

    @NotBlank(message = GeneralMessages.NOT_BLANK_NAME)
    @Size(min = 1, max = 25)
    private String name;

    @Size(min = 1, max = 25)
    private String patronymic;

    private ParentDTO parent;
//    boolean isPaid;


    public StudentDTO() {

    }

    public StudentDTO(String surname, String name, String patronymic, ParentDTO parent) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.parent = parent;
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

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }
}
