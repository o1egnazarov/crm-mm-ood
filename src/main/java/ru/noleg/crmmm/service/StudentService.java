package ru.noleg.crmmm.service;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.entity.Student;

import java.util.Collection;
import java.util.List;
@Service
public interface StudentService {
    Collection<Student> getStudentByParentId(long id);
    Payment pay(Student student, int amount);

    Student createStudent(Student student);

    Student updateStudent(long id, Student updatedStudent);

    void deleteStudent(long id);
    Collection<Student> getStudents();
}
