package ru.noleg.crmmm.controller.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ru.noleg.crmmm.messages.GeneralMessages;

import java.util.List;


public class GroupDTO {

    @NotBlank(message = "Название группы обязательно")
    @Size(min = 1, max = 25)
    private String title;

    public GroupDTO() {
    }

    public GroupDTO(String title,
                    List<StudentDTO> students,
                    List<LessonDTO> schedule) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
