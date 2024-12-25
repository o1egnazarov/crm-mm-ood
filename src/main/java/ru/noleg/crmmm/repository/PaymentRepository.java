package ru.noleg.crmmm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.noleg.crmmm.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
