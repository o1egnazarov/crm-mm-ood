package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Student;

import java.util.List;
import java.util.Map;

public interface LessonService {
    void createLesson(Lesson lesson);
    Lesson updateLesson(Long id, Lesson lesson);
    void deleteLesson(Long id);
    Lesson getLessonById(Long id);
    List<Lesson> getLessonsByTeacherId(Long teacherId);
    Map<Student, Boolean> markAttendance(Long id, Map<Student, Boolean> attendance);
}
