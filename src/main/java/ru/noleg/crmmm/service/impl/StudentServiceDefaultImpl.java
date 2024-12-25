package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.repository.StudentRepository;
import ru.noleg.crmmm.service.StudentService;

@Service
public class StudentServiceDefaultImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceDefaultImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
