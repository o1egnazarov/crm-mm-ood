package ru.noleg.crmmm.controller.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ru.noleg.crmmm.messages.GeneralMessages;

import java.time.LocalDateTime;

public class PaymentDTO {
    @NotNull(message = GeneralMessages.NOT_NULL_ID)
    @Positive(message = GeneralMessages.NOT_VALID_ID)
    private Long studentId;

    @NotNull(message = GeneralMessages.NOT_NULL_AMOUNT)
    @Positive(message = GeneralMessages.NOT_VALID_AMOUNT)
    private int amount;

    private LocalDateTime paymentDateTime;

    public PaymentDTO() {
    }

    public PaymentDTO(Long studentId,
                      int amount) {
        this.studentId = studentId;
        this.amount = amount;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public @NotNull(message = GeneralMessages.NOT_NULL_ID) @Positive(message = GeneralMessages.NOT_VALID_ID) Long getStudentId() {
        return studentId;
    }

    public void setStudentId(@NotNull(message = GeneralMessages.NOT_NULL_ID) @Positive(message = GeneralMessages.NOT_VALID_ID) Long studentId) {
        this.studentId = studentId;
    }

    @NotNull(message = GeneralMessages.NOT_NULL_AMOUNT)
    @Positive(message = GeneralMessages.NOT_VALID_AMOUNT)
    public int getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = GeneralMessages.NOT_NULL_AMOUNT) @Positive(message = GeneralMessages.NOT_VALID_AMOUNT) int amount) {
        this.amount = amount;
    }
}
