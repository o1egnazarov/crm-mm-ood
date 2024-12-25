package ru.noleg.crmmm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.noleg.crmmm.entity.Lesson;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    List<Lesson> getLessonsBygroupId(Long groupId);
}
