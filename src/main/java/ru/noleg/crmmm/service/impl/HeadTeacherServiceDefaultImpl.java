package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.entity.Teacher;
import ru.noleg.crmmm.repository.HeadTeacherRepository;
import ru.noleg.crmmm.repository.TeacherRepository;
import ru.noleg.crmmm.service.HeadTeacherService;

import java.util.NoSuchElementException;

@Service
public class HeadTeacherServiceDefaultImpl implements HeadTeacherService {
    private HeadTeacherRepository headTeacherRepository;
    private TeacherRepository teacherRepository;

    public void HeadTeacherServiceImpl(HeadTeacherRepository headTeacherRepository) {
        this.headTeacherRepository = headTeacherRepository;
    }

    @Override
    public void createHeadTeacher(HeadTeacher headTeacher) {
        headTeacherRepository.save(headTeacher);
    }


    @Override
    public void deleteHeadTeacher(Long id) {
        HeadTeacher existingHeadTeacher = getHeadTeacherById(id);
        headTeacherRepository.delete(existingHeadTeacher);
    }

    @Override
    public HeadTeacher getHeadTeacherById(Long id) {
        return headTeacherRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("HeadTeacher with id " + id + " not found"));
    }

    @Override
    public HeadTeacher updateHeadTeacher(Long id, HeadTeacher headTeacher) {
        // Проверяем, существует ли HeadTeacher с указанным id
        HeadTeacher existingHeadTeacher = headTeacherRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("HeadTeacher with id " + id + " not found"));

        // Создаем новый объект, чтобы заменить только измененные поля
        HeadTeacher updatedHeadTeacher = new HeadTeacher(
                existingHeadTeacher.getId(),
                headTeacher.getName() != null ? headTeacher.getName() : existingHeadTeacher.getName(),
                headTeacher.getSurname() != null ? headTeacher.getSurname() : existingHeadTeacher.getSurname(),
                headTeacher.getPatronymic() != null ? headTeacher.getPatronymic() : existingHeadTeacher.getPatronymic(),
                headTeacher.getTeachers() != null ? headTeacher.getTeachers() : existingHeadTeacher.getTeachers()
        );

        // Сохраняем изменения в репозиторий
        return headTeacherRepository.save(updatedHeadTeacher);
    }

    @Override
    public void removeGroupFromTeacher(Teacher teacher, Long groupId) {
        teacher.removeGroup(groupId);
        teacherRepository.save(teacher); // Сохраняем изменения в репозиторий

    }

    @Override
    public void assignTeacherToGroup(Teacher teacher, Group group) {
        teacher.addGroup(group);
        teacherRepository.save(teacher); // Сохраняем изменения в репозиторий
    }
}
