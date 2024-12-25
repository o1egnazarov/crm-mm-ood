package ru.noleg.crmmm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class PaymentEntity {
    private LocalDateTime paymentDateTime;
    private StudentEntity studentEntity;
    private int amount;
}
