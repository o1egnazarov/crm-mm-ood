package ru.noleg.crmmm.service.impl;


import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.repository.PaymentRepository;
import ru.noleg.crmmm.service.PaymentService;

import java.util.List;

@Service
public class PaymentServiceDefaultImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceDefaultImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void acceptPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment() {
        return paymentRepository.findLatestPayment();
    }
    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Retrieve a payment by ID
    @Override
    public Payment getPaymentById(long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    // Update an existing payment
    @Override
    public Payment updatePayment(long id, Payment updatedPayment) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        // Update fields as needed (for example, updating payment amount or status)
        existingPayment.setAmount(updatedPayment.getAmount());
        existingPayment.setPaymentDateTime(updatedPayment.getPaymentDateTime());
        // You can add more fields as needed

        return paymentRepository.save(existingPayment);
    }

    // Delete a payment by ID
    @Override
    public void deletePayment(long id) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        paymentRepository.delete(existingPayment);
    }

    // Retrieve all payments
    @Override
    public List<Payment> getAllPayments() {
        return (List<Payment>) paymentRepository.findAll();
    }
}