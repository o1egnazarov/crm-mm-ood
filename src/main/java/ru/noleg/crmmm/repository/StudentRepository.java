package ru.noleg.crmmm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.noleg.crmmm.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
