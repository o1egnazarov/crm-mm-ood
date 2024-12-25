package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Student;

import java.util.List;
import java.util.Map;

public interface LessonService {
    Long createLesson(Lesson lesson);
    void deleteLesson(long id);
    void updateLesson(long id, Lesson lesson);
    Map<Student, Boolean> markAttendance(Long id, Map<Student, Boolean> attendance);
}
