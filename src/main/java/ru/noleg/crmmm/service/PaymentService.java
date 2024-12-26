package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Payment;

import java.util.Collection;

public interface PaymentService {

    Payment acceptPayment(Payment payment);

    void deletePayment(long id);

    Payment updatePayment(long id, Payment updatedPayment);

    Payment getLatestPayment();

    Payment getPaymentById(long id);

    Collection<Payment> getPayments();
}
