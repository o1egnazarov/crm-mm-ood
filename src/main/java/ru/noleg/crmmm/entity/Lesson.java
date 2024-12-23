package ru.noleg.crmmm.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Class {
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Map<Student, Boolean> attendance;
}
