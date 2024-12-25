package ru.noleg.crmmm.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.noleg.crmmm.exception.ErrorDetails;
import ru.noleg.crmmm.exception.GroupNotFoundException;
import ru.noleg.crmmm.exception.TeacherNotFoundException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionTeacherNotFound(TeacherNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage("Такого учителя не существует!");
        errorDetails.setStatus(HttpStatus.BAD_REQUEST);
        errorDetails.setDetails(e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionGroupNotFound(GroupNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage("Такой группы не существует!");
        errorDetails.setStatus(HttpStatus.BAD_REQUEST);
        errorDetails.setDetails(e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
