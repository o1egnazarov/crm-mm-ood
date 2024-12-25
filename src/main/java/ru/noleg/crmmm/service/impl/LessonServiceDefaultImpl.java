package ru.noleg.crmmm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.noleg.crmmm.repository.LessonRepository;
import ru.noleg.crmmm.service.LessonService;

@Service
@RequiredArgsConstructor
public class LessonServiceDefaultImpl implements LessonService {
    private final LessonRepository lessonRepository;
}
