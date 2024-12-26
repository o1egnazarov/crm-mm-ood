package ru.noleg.crmmm.exception.handler;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.noleg.crmmm.exception.ErrorDetails;
import ru.noleg.crmmm.exception.GroupNotFoundException;
import ru.noleg.crmmm.exception.HeadTeacherNotFoundException;
import ru.noleg.crmmm.exception.PaymentNotFoundException;
import ru.noleg.crmmm.exception.StudentNotFoundException;
import ru.noleg.crmmm.exception.TeacherNotFoundException;
import ru.noleg.crmmm.messages.GroupMessages;
import ru.noleg.crmmm.messages.HeadTeacherMessages;
import ru.noleg.crmmm.messages.TeacherMessages;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionTeacherNotFound(TeacherNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage(TeacherMessages.TEACHER_NOT_EXIST);
        errorDetails.setStatus(HttpStatus.BAD_REQUEST);
        errorDetails.setDetails(e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionGroupNotFound(GroupNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage(GroupMessages.GROUP_NOT_EXIST);
        errorDetails.setStatus(HttpStatus.BAD_REQUEST);
        errorDetails.setDetails(e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetails> exceptionGroupNotFound(ValidationException e) {
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setStatus(HttpStatus.BAD_REQUEST);
        errorDetails.setDetails(e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler({StudentNotFoundException.class, PaymentNotFoundException.class})
    public ResponseEntity<ErrorDetails> exceptionStudentNotFound(RuntimeException e) {
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setStatus(HttpStatus.BAD_REQUEST);
        errorDetails.setDetails(e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler({HeadTeacherNotFoundException.class})
    public ResponseEntity<ErrorDetails> exceptionHeadTeacherNotFound(RuntimeException e) {
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage(HeadTeacherMessages.HEAD_TEACHER_NOT_EXIST);
        errorDetails.setStatus(HttpStatus.BAD_REQUEST);
        errorDetails.setDetails(e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
