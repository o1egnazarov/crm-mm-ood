package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.repository.LessonRepository;
import ru.noleg.crmmm.service.LessonService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LessonServiceDefaultImpl implements LessonService {
    private final LessonRepository lessonRepository;

    public LessonServiceDefaultImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Long createLesson(Lesson lesson) {
        // Сохраняем новый урок в базу данных
        Lesson savedLesson = lessonRepository.save(lesson);
        return savedLesson.getId();
    }

    @Override
    public void deleteLesson(long id) {
        // Удаляем урок по ID
        lessonRepository.deleteById(id);
    }

    @Override
    public void updateLesson(long id, Lesson updatedLesson) {
        // Ищем существующий урок
        Optional<Lesson> existingLesson = lessonRepository.findById(id);
        if (existingLesson.isPresent()) {
            Lesson lesson = existingLesson.get();

            // Создаем новый объект Lesson с обновленными данными
            Lesson newLesson = new Lesson(
                    lesson.getId(),          // ID остается неизменным
                    updatedLesson.getTitle(), // Новое имя
                    updatedLesson.getStartDateTime(),
                    updatedLesson.getEndDateTime(), // Новая дата
                    updatedLesson.getGroup(),
                    updatedLesson.getAttendance() // Новая карта посещаемости
            );

            // Сохраняем новый объект
            lessonRepository.save(newLesson);
        } else {
            throw new IllegalArgumentException("Lesson with id " + id + " not found.");
        }
    }

    @Override
    public Map<Student, Boolean> markAttendance(Long id, Map<Student, Boolean> attendance) {
        // Ищем урок по ID
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);

        if (optionalLesson.isPresent()) {
            Lesson lesson = optionalLesson.get();

            // Обновляем карту посещаемости путем создания нового объекта Lesson
            Lesson updatedLesson = new Lesson(
                    lesson.getId(),
                    lesson.getTitle(),
                    lesson.getStartDateTime(),
                    lesson.getEndDateTime(),
                    lesson.getGroup(),
                    attendance // Устанавливаем новую карту посещаемости
            );

            // Сохраняем обновленный урок
            lessonRepository.save(updatedLesson);

            return attendance;
        } else {
            throw new IllegalArgumentException("Lesson with id " + id + " not found.");
        }
    }
    @Override
    public List<Lesson> getLessonsByGroup(Long groupId){
        return lessonRepository.getLessonsBygroupId(groupId);
    }
}
