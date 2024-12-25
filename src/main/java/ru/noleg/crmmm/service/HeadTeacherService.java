package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.HeadTeacher;

public interface HeadTeacherService {
    void createHeadTeacher(HeadTeacher headTeacher);

    HeadTeacher updateHeadTeacher(Long id, HeadTeacher headTeacher);

    void deleteHeadTeacher(Long id);

    HeadTeacher getHeadTeacherById(Long id);
}
