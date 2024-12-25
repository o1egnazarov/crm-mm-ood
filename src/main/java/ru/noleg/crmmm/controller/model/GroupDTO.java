package ru.noleg.crmmm.controller.model;


import java.util.List;


public class GroupDTO {

    private String title;
    private List<StudentDTO> students;
    private List<LessonDTO> schedule;

    public GroupDTO() {
    }

    public GroupDTO(String title,
                    List<StudentDTO> students,
                    List<LessonDTO> schedule) {
        this.title = title;
        this.students = students;
        this.schedule = schedule;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

    public List<LessonDTO> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<LessonDTO> schedule) {
        this.schedule = schedule;
    }
}
