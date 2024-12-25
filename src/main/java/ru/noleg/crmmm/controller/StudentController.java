package ru.noleg.crmmm.controller;

import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.noleg.crmmm.controller.mapper.PaymentMapper;
import ru.noleg.crmmm.controller.mapper.StudentMapper;
import ru.noleg.crmmm.controller.model.PaymentDTO;
import ru.noleg.crmmm.controller.model.StudentDTO;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.messages.GeneralMessages;
import ru.noleg.crmmm.service.StudentService;
import ru.noleg.crmmm.utils.ValidationUtils;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentController {
    private final ValidationUtils validator;
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final PaymentMapper paymentMapper;

    public StudentController(ValidationUtils validator, StudentService studentService, StudentMapper studentMapper, PaymentMapper paymentMapper) {
        this.validator = validator;
        this.studentService = studentService;
        this.studentMapper = studentMapper;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        this.validator.validationRequest(studentDTO);

        Student student = studentMapper.toEntity(studentDTO);
        this.studentService.createStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long id,
                                                    @RequestBody StudentDTO studentDTO) {
        this.validator.validationRequest(studentDTO);

        Student student = studentMapper.toEntity(studentDTO);
        Student studentUpdated = this.studentService.updateStudent(id, student);
        StudentDTO studentDtoUpdated = studentMapper.toDto(studentUpdated);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentDtoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {

        this.studentService.deleteStudent(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {
        Student student = this.studentService.getStudentById(id);
        StudentDTO studentDTO = studentMapper.toDto(student);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentDTO);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents() {
        Collection<Student> students = this.studentService.getStudents();
        List<StudentDTO> studentDTOS = this.studentMapper.toDtos(students);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentDTOS);
    }

    @GetMapping("/parents/{id}")
    public ResponseEntity<List<StudentDTO>> getStudentByParent(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {

        List<Student> students = this.studentService.getStudentByParentId(id);
        List<StudentDTO> studentDTOS = this.studentMapper.toDtos(students);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentDTOS);

    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentDTO> pay(@RequestBody PaymentDTO paymentDTO) {
        this.validator.validationRequest(paymentDTO);

        Payment updatedPayment = this.studentService.pay(paymentDTO.getStudentId(), paymentDTO.getAmount());
        PaymentDTO paymentDTOUpdated = this.paymentMapper.toDto(updatedPayment);
        paymentDTOUpdated.setStudentId(paymentDTO.getStudentId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(paymentDTOUpdated);
    }

}
