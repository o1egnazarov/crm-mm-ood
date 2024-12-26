package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.exception.LessonNotFoundException;
import ru.noleg.crmmm.messages.LessonMessages;
import ru.noleg.crmmm.repository.LessonRepository;
import ru.noleg.crmmm.service.LessonService;
import ru.noleg.crmmm.service.TeacherService;

import java.util.List;
import java.util.Map;

@Service
public class LessonServiceDefaultImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final TeacherService teacherService;

    public LessonServiceDefaultImpl(LessonRepository lessonRepository, TeacherService teacherService) {
        this.lessonRepository = lessonRepository;
        this.teacherService = teacherService;
    }

    @Override
    public Long createLesson(Lesson lesson) {
        Lesson createdLesson = lessonRepository.save(lesson);
        return createdLesson.getId();
    }

    @Override
    public Lesson getLessonById(Long id) {
        return this.lessonRepository.findById(id).orElseThrow(
                () -> new LessonNotFoundException(String.format(LessonMessages.LESSON_ERROR_NOT_EXIST, id))
        );
    }

    @Override
    public void deleteLesson(Long id) {
        Lesson lesson = this.getLessonById(id);
        lessonRepository.delete(lesson);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        Lesson existingLesson = this.getLessonById(id);

        existingLesson.setTitle(lesson.getTitle());
        existingLesson.setStartDateTime(lesson.getStartDateTime());
        existingLesson.setEndDateTime(lesson.getEndDateTime());
        existingLesson.setAttendance(lesson.getAttendance());
        existingLesson.setGroup(lesson.getGroup());

        return this.lessonRepository.save(existingLesson);
    }

    public Map<Student, Boolean> markAttendance(Long id, Map<Student, Boolean> attendance) {

        Lesson lesson = this.getLessonById(id);

        Lesson updatedLesson = new Lesson(
                lesson.getId(),
                lesson.getTitle(),
                lesson.getStartDateTime(),
                lesson.getEndDateTime(),
                lesson.getGroup(),
                attendance
        );

        lessonRepository.save(updatedLesson);

        return attendance;

    }


    @Override
    public List<Lesson> getLessonsByTeacherId(Long teacherId) {
        return this.teacherService.getLessonsByTeacherId(teacherId);
    }
}
