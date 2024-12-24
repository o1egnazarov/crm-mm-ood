package ru.noleg.crmmm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.noleg.crmmm.repository.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
