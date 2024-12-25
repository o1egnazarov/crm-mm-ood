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
import ru.noleg.crmmm.controller.model.HeadTeacherDTO;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.messages.GeneralMessages;
import ru.noleg.crmmm.service.HeadTeacherService;
import ru.noleg.crmmm.utils.ValidationUtils;

@RestController
@RequestMapping("/v1/head_teachers")
public class HeadTeacherController {
    private final ValidationUtils validator;
    private final HeadTeacherService headTeacherService;
    private final HeadTeacherMapper headTeacherMapper;

    public HeadTeacherController(ValidationUtils validator, HeadTeacherService headTeacherService, HeadTeacherMapper headTeacherMapper) {
        this.validator = validator;
        this.headTeacherService = headTeacherService;
        this.headTeacherMapper = headTeacherMapper;
    }


    @PostMapping
    public ResponseEntity<?> createHeadTeacher(@RequestBody HeadTeacherDTO headTeacherDTO) {
        this.validator.validationRequest(headTeacherDTO);

        HeadTeacher headTeacher = headTeacherMapper.toEntity(headTeacherDTO);
        this.headTeacherService.createHeadTeacher(headTeacher);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHeadTeacher(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {

        this.headTeacherService.deleteHeadTeacher(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<HeadTeacherDTO> getTeacher(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {
        HeadTeacher headTeacher = this.headTeacherService.getHeadTeacherById(id);
        HeadTeacherDTO headTeacherDTO = headTeacherMapper.toDto(headTeacher);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(headTeacherDTO);
    }


}


