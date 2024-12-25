package ru.noleg.crmmm.controller.model;



import java.time.LocalDateTime;
import java.util.Map;


public class LessonDTO {
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Map<StudentDTO, Boolean> attendance;


    public LessonDTO() {
    }

    public LessonDTO(String title,
                     LocalDateTime startDateTime,
                     LocalDateTime endDateTime,
                     Map<StudentDTO, Boolean> attendance) {

        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.attendance = attendance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Map<StudentDTO, Boolean> getAttendance() {
        return attendance;
    }

    public void setAttendance(Map<StudentDTO, Boolean> attendance) {
        this.attendance = attendance;
    }
}
