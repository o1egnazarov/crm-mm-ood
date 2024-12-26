package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.exception.PaymentNotFoundException;
import ru.noleg.crmmm.messages.PaymentMessages;
import ru.noleg.crmmm.repository.PaymentRepository;
import ru.noleg.crmmm.service.PaymentService;

import java.util.Collection;
import java.util.List;

@Service
public class PaymentServiceDefaultImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceDefaultImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment acceptPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getLatestPayment() {
        Payment latestPayment = paymentRepository.findLatestPayment();
        if (latestPayment == null) {
            throw new PaymentNotFoundException(PaymentMessages.PAYMENT_LATEST_NOT_EXIST);
        }

        return paymentRepository.findLatestPayment();
    }


    @Override
    public Payment getPaymentById(long id) {
        return paymentRepository.findById(id).orElseThrow(
                () -> new PaymentNotFoundException(String.format(PaymentMessages.PAYMENT_ERROR_NOT_EXIST, id))
        );
    }


    @Override
    public Payment updatePayment(long id, Payment updatedPayment) {
        Payment existingPayment = this.getPaymentById(id);

        existingPayment.setAmount(updatedPayment.getAmount());
        existingPayment.setPaymentDateTime(updatedPayment.getPaymentDateTime());
        existingPayment.setStudent(updatedPayment.getStudent());

        return paymentRepository.save(existingPayment);
    }


    @Override
    public void deletePayment(long id) {
        Payment existingPayment = this.getPaymentById(id);
        paymentRepository.delete(existingPayment);
    }


    @Override
    public Collection<Payment> getPayments() {
        return (List<Payment>) paymentRepository.findAll();
    }
}
