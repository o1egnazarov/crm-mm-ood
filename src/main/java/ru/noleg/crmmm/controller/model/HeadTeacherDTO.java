package ru.noleg.crmmm.controller.model;


import java.util.List;


public class HeadTeacherDTO {
    private String surname;
    private String name;
    private String patronymic;
    private List<TeacherDTO> teachers;

    public HeadTeacherDTO() {
    }

    public HeadTeacherDTO(String surname,
                          String name,
                          String patronymic,
                          List<TeacherDTO> teachers) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.teachers = teachers;
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

    public List<TeacherDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherDTO> teachers) {
        this.teachers = teachers;
    }
}
