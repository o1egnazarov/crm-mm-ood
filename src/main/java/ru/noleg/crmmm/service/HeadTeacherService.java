package ru.noleg.crmmm.service;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.entity.Teacher;
@Service
public interface HeadTeacherService {
    void createHeadTeacher(HeadTeacher headTeacher);
    void deleteHeadTeacher(Long id);
    HeadTeacher getHeadTeacherById(Long id);
    public HeadTeacher updateHeadTeacher(Long id, HeadTeacher headTeacher);
    void removeGroupFromTeacher(Teacher teacher, Long groupId);
    void assignTeacherToGroup(Teacher teacher, Group group);
    }
