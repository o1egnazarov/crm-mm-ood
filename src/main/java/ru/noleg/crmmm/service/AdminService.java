package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Payment;

import java.util.Collection;
import java.util.List;

public interface AdminService {
    Collection<Payment> getPayments();
}
