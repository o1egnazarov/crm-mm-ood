package ru.noleg.crmmm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.noleg.crmmm.entity.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
