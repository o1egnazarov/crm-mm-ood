package ru.noleg.crmmm.service;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Payment;
@Service
public interface PaymentService {
    void acceptPayment(Payment payment);
    Payment getPayment();
}
