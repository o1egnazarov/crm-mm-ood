package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.entity.Payment;

import java.util.List;

public interface AdminService {
    List<Payment> getPayments();
    void addHeadTeacher(HeadTeacher headTeacher);
    void fireHeadTeacher(Long headTeacherId);
    void editHeadTeacher(Long headTeacherId, HeadTeacher headTeacher);
}
