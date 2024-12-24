package ru.noleg.crmmm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.noleg.crmmm.repository.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
