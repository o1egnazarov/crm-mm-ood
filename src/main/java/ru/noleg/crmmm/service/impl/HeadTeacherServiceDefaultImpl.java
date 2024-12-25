package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.repository.HeadTeacherRepository;
import ru.noleg.crmmm.service.HeadTeacherService;

@Service
public class HeadTeacherServiceDefaultImpl implements HeadTeacherService {
    private final HeadTeacherRepository headTeacherRepository;

    public HeadTeacherServiceDefaultImpl(HeadTeacherRepository headTeacherRepository) {
        this.headTeacherRepository = headTeacherRepository;
    }

    @Override
    public void createHeadTeacher(HeadTeacher headTeacher) {

    }

    @Override
    public HeadTeacher updateHeadTeacher(Long id, HeadTeacher headTeacher) {
        return null;
    }

    @Override
    public void deleteHeadTeacher(Long id) {

    }

    @Override
    public HeadTeacher getHeadTeacherById(Long id) {
        return null;
    }
}
