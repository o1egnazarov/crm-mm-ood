package ru.noleg.crmmm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.TeacherEntity;
import ru.noleg.crmmm.repository.TeacherRepository;
import ru.noleg.crmmm.repository.model.Teacher;
import ru.noleg.crmmm.service.TeacherService;
import ru.noleg.crmmm.service.mapper.TeacherMapper;

@Service
@RequiredArgsConstructor
public class TeacherServiceDefaultImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherEntity createTeacher(TeacherEntity teacherEntity) {
        Teacher teacher = teacherMapper.toEntity(teacherEntity);
        Teacher savedTeacher = this.teacherRepository.save(teacher);
        return teacherMapper.toDto(savedTeacher);
    }
}
