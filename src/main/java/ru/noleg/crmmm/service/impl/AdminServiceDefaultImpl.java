package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.service.AdminService;
import ru.noleg.crmmm.service.PaymentService;

import java.util.Collection;

@Service
public class AdminServiceDefaultImpl implements AdminService {
    private final PaymentService paymentService;

    public AdminServiceDefaultImpl(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public Collection<Payment> getPayments() {
        return this.paymentService.getPayments();
    }
}
