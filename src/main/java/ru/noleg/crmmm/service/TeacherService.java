package ru.noleg.crmmm.service;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Teacher;
@Service
public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
}
