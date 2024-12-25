package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findByParent(long id);
    Payment pay(Student student, int amount);
}
