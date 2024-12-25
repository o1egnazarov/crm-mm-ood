package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Teacher;
import ru.noleg.crmmm.repository.TeacherRepository;
import ru.noleg.crmmm.service.TeacherService;

@Service
public class TeacherServiceDefaultImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceDefaultImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }
}
