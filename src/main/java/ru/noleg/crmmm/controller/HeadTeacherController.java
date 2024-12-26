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
import ru.noleg.crmmm.controller.mapper.TeacherMapper;
import ru.noleg.crmmm.controller.model.HeadTeacherDTO;
import ru.noleg.crmmm.controller.model.TeacherDTO;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.entity.Teacher;
import ru.noleg.crmmm.messages.GeneralMessages;
import ru.noleg.crmmm.service.HeadTeacherService;
import ru.noleg.crmmm.utils.ValidationUtils;

@RestController
@RequestMapping("/v1/head_teachers")
public class HeadTeacherController {
    private final ValidationUtils validator;
    private final HeadTeacherService headTeacherService;
    private final HeadTeacherMapper headTeacherMapper;
    private final TeacherMapper teacherMapper;

    public HeadTeacherController(ValidationUtils validator,
                                 HeadTeacherService headTeacherService,
                                 HeadTeacherMapper headTeacherMapper,
                                 TeacherMapper teacherMapper) {
        this.validator = validator;
        this.headTeacherService = headTeacherService;
        this.headTeacherMapper = headTeacherMapper;
        this.teacherMapper = teacherMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeadTeacherDTO> getHeadTeacher(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {
        HeadTeacher headTeacher = this.headTeacherService.getHeadTeacherById(id);
        HeadTeacherDTO headTeacherDTO = headTeacherMapper.toDto(headTeacher);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(headTeacherDTO);
    }

    @PostMapping("/groups/{groupId}/teachers/{teacherId}")
    public ResponseEntity<TeacherDTO> assignTeacherToGroup(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long groupId,
                                                           @PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long teacherId) {
        Teacher teacher = this.headTeacherService.assignTeacherToGroup(teacherId, groupId);
        TeacherDTO teacherDTO = this.teacherMapper.toDto(teacher);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(teacherDTO);

    }

    @DeleteMapping("/groups/{groupId}/teachers/{teacherId}")
    public ResponseEntity<TeacherDTO> removeTeacherFromGroup(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long groupId,
                                                             @PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long teacherId) {
        Teacher teacher = this.headTeacherService.removeGroupFromTeacher(teacherId, groupId);
        TeacherDTO teacherDTO = this.teacherMapper.toDto(teacher);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(teacherDTO);

    }


}


