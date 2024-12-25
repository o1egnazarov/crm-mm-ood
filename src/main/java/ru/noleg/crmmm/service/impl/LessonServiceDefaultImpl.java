package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.repository.LessonRepository;
import ru.noleg.crmmm.service.LessonService;

@Service
public class LessonServiceDefaultImpl implements LessonService {
    private final LessonRepository lessonRepository;

    public LessonServiceDefaultImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
}
