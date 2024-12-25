package ru.noleg.crmmm.service;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Payment;

import java.util.List;

@Service
public interface PaymentService {
    void acceptPayment(Payment payment);
    Payment getPayment();

    Payment createPayment(Payment payment);

    // Retrieve a payment by ID
    Payment getPaymentById(long id);

    // Update an existing payment
    Payment updatePayment(long id, Payment updatedPayment);

    // Delete a payment by ID
    void deletePayment(long id);

    // Retrieve all payments
    List<Payment> getAllPayments();
}
