package ru.noleg.crmmm.controller.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ru.noleg.crmmm.messages.GeneralMessages;

public class ParentDTO {
    @NotBlank(message = GeneralMessages.NOT_BLANK_SURNAME)
    @Size(min = 1, max = 25)
    private String surname;

    @NotBlank(message = GeneralMessages.NOT_BLANK_NAME)
    @Size(min = 1, max = 25)
    private String name;

    @Size(min = 1, max = 25)
    private String patronymic;

    @NotBlank(message = GeneralMessages.NOT_BLANK_EMAIL)
    @Email(message = GeneralMessages.NOT_VALID_EMAIL)
    private String email;

    public ParentDTO() {
    }

    public ParentDTO(String surname, String name, String patronymic, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
