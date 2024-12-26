package ru.noleg.crmmm.controller.model;


import java.util.List;


public class TeacherDTO {
    private String surname;
    private String name;
    private String patronymic;
    private List<GroupDTO> groups;

    public TeacherDTO() {
    }

    public TeacherDTO(String surname, String name, String patronymic, List<GroupDTO> groups) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.groups = groups;
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

    public List<GroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDTO> groups) {
        this.groups = groups;
    }

}
