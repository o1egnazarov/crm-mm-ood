package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Student;

import java.util.Collection;

public interface StudentService {
    void createStudent(Student student);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    Student getStudentById(Long id);

    Collection<Student> getStudents();

    Student getStudentByParentId(Long id);

    void pay(Long studentId, int amount);
}
