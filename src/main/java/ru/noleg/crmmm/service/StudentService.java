package ru.noleg.crmmm.service;

import jakarta.validation.constraints.Positive;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Long createStudent(Student student);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    Student getStudentById(Long id);

    Collection<Student> getStudents();

    List<Student> getStudentByParentId(Long id);

    Payment pay(Long studentId, int amount);

    List<Student> getStudentByGroupId(Long id);
}
