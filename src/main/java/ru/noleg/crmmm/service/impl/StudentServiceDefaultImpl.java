package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.repository.StudentRepository;
import ru.noleg.crmmm.service.StudentService;

import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceDefaultImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceDefaultImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student) {

    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public Student getStudentById(Long id) {
        return null;
    }

    @Override
    public Collection<Student> getStudents() {
        return List.of();
    }

    @Override
    public Student getStudentByParentId(Long id) {
        return null;
    }

    @Override
    public void pay(Long studentId, int amount) {

    }
}
