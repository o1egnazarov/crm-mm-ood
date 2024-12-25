package ru.noleg.crmmm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.noleg.crmmm.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    @Query("SELECT p FROM Payment p ORDER BY p.paymentDateTime DESC LIMIT 1")
    Payment findLatestPayment();
}
