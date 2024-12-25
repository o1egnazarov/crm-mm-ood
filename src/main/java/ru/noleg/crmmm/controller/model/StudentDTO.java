package ru.noleg.crmmm.controller.model;





public class StudentDTO {
    private String surname;
    private String name;
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
