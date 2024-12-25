package ru.noleg.crmmm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class LessonEntity {
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Map<StudentEntity, Boolean> attendance;
}
