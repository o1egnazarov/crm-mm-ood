package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.exception.StudentNotFoundException;
import ru.noleg.crmmm.messages.StudentMessages;
import ru.noleg.crmmm.repository.StudentRepository;
import ru.noleg.crmmm.service.PaymentService;
import ru.noleg.crmmm.service.StudentService;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
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
    public void createStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return this.studentRepository.findById(id).orElseThrow(
                () -> new StudentNotFoundException(String.format(StudentMessages.STUDENT_ERROR_NOT_EXIST, id))
        );
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = this.getStudentById(id);
        studentRepository.delete(student);
    }


    @Override
    public List<Student> getStudentByParentId(Long id) {
        return StreamSupport.stream(this.studentRepository.findAll().spliterator(), false)
                .filter(student -> student.getParent() != null && student.getParent().getId() == id)
                .toList();
    }

    @Override
    public Payment pay(Long id, int amount) {
        Student student = this.getStudentById(id);
        if (student.isPaid()) {
            return new Payment(student.getPayment().getPaymentDateTime(), student, student.getPayment().getAmount());
        }

        Payment payment = new Payment(LocalDateTime.now(), student, amount);

        this.paymentService.acceptPayment(payment);
        student.setPaid(true);
        this.studentRepository.save(student);

        return payment;
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = this.getStudentById(id);

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setParent(updatedStudent.getParent());
        existingStudent.setSurname(updatedStudent.getSurname());
        existingStudent.setPatronymic(updatedStudent.getPatronymic());

        return studentRepository.save(existingStudent);
    }


    @Override
    public Collection<Student> getStudents() {
        return (Collection<Student>) studentRepository.findAll();
    }

}