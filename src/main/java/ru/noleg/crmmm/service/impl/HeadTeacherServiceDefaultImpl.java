package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.repository.HeadTeacherRepository;
import ru.noleg.crmmm.service.HeadTeacherService;

@Service
public class HeadTeacherServiceDefaultImpl implements HeadTeacherService {
    private final HeadTeacherRepository headTeacherRepository;

    public HeadTeacherServiceDefaultImpl(HeadTeacherRepository headTeacherRepository) {
        this.headTeacherRepository = headTeacherRepository;
    }
}
