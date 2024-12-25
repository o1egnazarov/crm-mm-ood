package ru.noleg.crmmm.service.impl;


import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.repository.PaymentRepository;
import ru.noleg.crmmm.service.PaymentService;

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
}