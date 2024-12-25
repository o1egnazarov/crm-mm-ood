package ru.noleg.crmmm.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class ValidationUtils {
    private final Validator validator;

    public ValidationUtils(Validator validator) {
        this.validator = validator;
    }

    public <T> void validationRequest(T request) {
        if (request != null) {
            Set<ConstraintViolation<T>> resultValidation = this.validator.validate(request);
            if (!resultValidation.isEmpty()) {
                String result = resultValidation
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .reduce((s1, s2) -> s1 + "\n " + s2)
                        .orElse("");
                throw new ValidationException(result);
            }
        }
    }
}