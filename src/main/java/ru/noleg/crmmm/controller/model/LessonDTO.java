package ru.noleg.crmmm.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.noleg.crmmm.entity.StudentEntity;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class LessonDTO {
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Map<StudentEntity, Boolean> attendance;
}
