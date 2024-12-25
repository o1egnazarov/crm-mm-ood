package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.entity.Teacher;

public interface HeadTeacherService {
    void createHeadTeacher(HeadTeacher headTeacher);

    HeadTeacher updateHeadTeacher(Long id, HeadTeacher headTeacher);

    void deleteHeadTeacher(Long id);

    HeadTeacher getHeadTeacherById(Long id);

    Teacher assignTeacherToGroup(Long teacherId, Long groupId);

    Teacher removeGroupFromTeacher(Long teacherId, Long groupId);
}
