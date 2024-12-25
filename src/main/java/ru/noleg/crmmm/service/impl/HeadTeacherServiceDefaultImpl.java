package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.entity.Teacher;
import ru.noleg.crmmm.repository.HeadTeacherRepository;
import ru.noleg.crmmm.service.HeadTeacherService;

import java.util.NoSuchElementException;

@Service
public class HeadTeacherServiceDefaultImpl implements HeadTeacherService {
    private HeadTeacherRepository headTeacherRepository;

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
    public void removeGroupFromTeacher(Teacher teacher, Long groupId) {
        teacher.removeGroup(groupId);
    }

    @Override
    public void assignTeacherToGroup(Teacher teacher, Group group) {
        teacher.addGroup(group);
    }
}
