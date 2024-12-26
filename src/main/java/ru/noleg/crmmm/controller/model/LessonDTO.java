package ru.noleg.crmmm.controller.model;



import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Map;


public class LessonDTO {
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;
    @NotNull(message = "Start date and time cannot be null")
    private LocalDateTime startDateTime;
    @NotNull(message = "End date and time cannot be null")
    @Future(message = "End date and time must be in the future")
    private LocalDateTime endDateTime;



    public LessonDTO() {
    }

    public LessonDTO(String title,
                     LocalDateTime startDateTime,
                     LocalDateTime endDateTime,
                     Map<StudentDTO, Boolean> attendance) {

        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
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

}
