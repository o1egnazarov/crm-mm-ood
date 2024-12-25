package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.repository.HeadTeacherRepository;
import ru.noleg.crmmm.repository.PaymentRepository;
import ru.noleg.crmmm.service.AdminService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdminServiceDefaultImpl implements AdminService {
    private HeadTeacherRepository headTeacherRepository;
    private PaymentRepository paymentRepository;

    public void AdminServiceImpl(HeadTeacherRepository headTeacherRepository) {
        this.headTeacherRepository = headTeacherRepository;
    }

    @Override
    public List<Payment> getPayments() {
        return (List<Payment>) paymentRepository.findAll();

    }

    @Override
    public void addHeadTeacher(HeadTeacher headTeacher) {
        headTeacherRepository.save(headTeacher);
    }

    @Override
    public void fireHeadTeacher(Long headTeacherId) {
        headTeacherRepository.deleteById(headTeacherId);
    }

    @Override
    public void editHeadTeacher(Long headTeacherId, HeadTeacher headTeacher) {
        HeadTeacher existingHeadTeacher = headTeacherRepository.findById(headTeacherId)
                .orElseThrow(() -> new NoSuchElementException("HeadTeacher with id " + headTeacherId + " not found"));

        // Обновляем только те поля, которые переданы в новом объекте
        if (headTeacher.getName() != null) {
            existingHeadTeacher.setName(headTeacher.getName());
        }
        if (headTeacher.getTeachers() != null) {
            existingHeadTeacher.setTeachers(headTeacher.getTeachers());
        }

        // Сохраняем обновленную сущность
        headTeacherRepository.save(existingHeadTeacher);
    }
}
