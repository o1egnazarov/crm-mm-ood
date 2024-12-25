package ru.noleg.crmmm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.noleg.crmmm.repository.StudentRepository;
import ru.noleg.crmmm.service.StudentService;

@Service
@RequiredArgsConstructor
public class StudentServiceDefaultImpl implements StudentService {
    private final StudentRepository studentRepository;
}
