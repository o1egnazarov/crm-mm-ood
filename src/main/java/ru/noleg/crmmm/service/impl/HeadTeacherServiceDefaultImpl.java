package ru.noleg.crmmm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.noleg.crmmm.repository.HeadTeacherRepository;
import ru.noleg.crmmm.service.HeadTeacherService;

@Service
@RequiredArgsConstructor
public class HeadTeacherServiceDefaultImpl implements HeadTeacherService {
    private final HeadTeacherRepository headTeacherRepository;
}
