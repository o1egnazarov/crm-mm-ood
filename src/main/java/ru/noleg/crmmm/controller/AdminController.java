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
import ru.noleg.crmmm.controller.mapper.HeadTeacherMapper;
import ru.noleg.crmmm.controller.mapper.PaymentMapper;
import ru.noleg.crmmm.controller.model.HeadTeacherDTO;
import ru.noleg.crmmm.controller.model.PaymentDTO;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.messages.GeneralMessages;
import ru.noleg.crmmm.service.AdminService;
import ru.noleg.crmmm.service.HeadTeacherService;
import ru.noleg.crmmm.utils.ValidationUtils;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("v1/admins")
public class AdminController {
    private final ValidationUtils validator;
    private final AdminService adminService;
    private final HeadTeacherMapper headTeacherMapper;
    private final PaymentMapper paymentMapper;
    private final HeadTeacherService headTeacherService;


    public AdminController(ValidationUtils validator,
                           AdminService adminService,
                           HeadTeacherMapper headTeacherMapper, PaymentMapper paymentMapper,
                           HeadTeacherService headTeacherService) {
        this.validator = validator;
        this.adminService = adminService;
        this.headTeacherMapper = headTeacherMapper;
        this.paymentMapper = paymentMapper;
        this.headTeacherService = headTeacherService;
    }


    @PostMapping("/head_teachers")
    public ResponseEntity<Long> createHeadTeacher(@RequestBody HeadTeacherDTO headTeacherDTO) {
        this.validator.validationRequest(headTeacherDTO);

        HeadTeacher headTeacher = headTeacherMapper.toEntity(headTeacherDTO);
        Long id = this.headTeacherService.createHeadTeacher(headTeacher);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(id);
    }

    @PutMapping("/head_teachers/{id}")
    public ResponseEntity<HeadTeacherDTO> updateHeadTeacher(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long id,
                                                            @RequestBody HeadTeacherDTO headTeacherDTO) {
        this.validator.validationRequest(headTeacherDTO);

        HeadTeacher headTeacher = headTeacherMapper.toEntity(headTeacherDTO);
        HeadTeacher headTeacherUpdated = this.headTeacherService.updateHeadTeacher(id, headTeacher);
        HeadTeacherDTO headTeacherDtoUpdated = headTeacherMapper.toDto(headTeacherUpdated);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(headTeacherDtoUpdated);
    }

    @DeleteMapping("/head_teachers/{id}")
    public ResponseEntity<?> deleteHeadTeacher(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {

        this.headTeacherService.deleteHeadTeacher(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentDTO>> getPayments() {
        Collection<Payment> payments = this.adminService.getPayments();
        List<PaymentDTO> paymentDtos = payments.stream()
                .map(payment -> {
                    PaymentDTO paymentDTO = this.paymentMapper.toDto(payment);
                    paymentDTO.setStudentId(payment.getStudent().getId());
                    return paymentDTO;
                })
                .toList();


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentDtos);
    }

}

