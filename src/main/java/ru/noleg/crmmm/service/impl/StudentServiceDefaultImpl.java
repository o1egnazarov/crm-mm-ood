package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.repository.StudentRepository;
import ru.noleg.crmmm.service.PaymentService;
import ru.noleg.crmmm.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceDefaultImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final PaymentService paymentService;

    public StudentServiceDefaultImpl(StudentRepository studentRepository, PaymentService paymentService) {
        this.studentRepository = studentRepository;
        this.paymentService = paymentService;
    }

    @Override
    public List<Student> getStudentByParentId(long id) {
        // Получение студентов по id родителя
        return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                .filter(student -> student.getParent() != null && student.getParent().getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public Payment pay(Student student, int amount) {
        // Создание нового объекта Payment
        Payment payment = new Payment(student, amount, true);

        // Обработка платежа через PaymentService
        paymentService.acceptPayment(payment);

        // Возврат нового объекта Payment
        return payment;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setParent(updatedStudent.getParent());

        return studentRepository.save(existingStudent);
    }
    @Override
    public void deleteStudent(long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(existingStudent);
    }

    @Override
    public Collection<Student> getStudents() {
        return (Collection<Student>) studentRepository.findAll();
    }

}
