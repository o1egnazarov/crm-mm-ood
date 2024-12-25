package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Teacher;

import java.util.Collection;
import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
    void deleteTeacher(Long id);
    Teacher updateTeacher(Long id, Teacher teacher);
    Teacher getTeacherById(Long id);
    Collection<Teacher> getTeachers();
    List<Lesson> getLessonsByTeacherId(Long teacherId);

}
