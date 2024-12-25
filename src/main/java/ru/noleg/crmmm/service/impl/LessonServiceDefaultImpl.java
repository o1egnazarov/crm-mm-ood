package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.repository.LessonRepository;
import ru.noleg.crmmm.service.LessonService;

import java.util.List;
import java.util.Map;

@Service
public class LessonServiceDefaultImpl implements LessonService {
    private final LessonRepository lessonRepository;

    public LessonServiceDefaultImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Long createLesson(Lesson lesson) {
        return 0L;
    }

    @Override
    public void deleteLesson(long id) {

    }

    @Override
    public void updateLesson(long id, Lesson lesson) {

    }

    @Override
    public Map<List<Student>, Boolean> markAttendance(Long id, Map<List<Student>, Boolean> attendance) {
        return Map.of();
    }
}
