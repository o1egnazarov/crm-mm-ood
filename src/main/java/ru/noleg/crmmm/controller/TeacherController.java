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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.noleg.crmmm.controller.mapper.LessonMapper;
import ru.noleg.crmmm.controller.mapper.TeacherMapper;
import ru.noleg.crmmm.controller.model.LessonDTO;
import ru.noleg.crmmm.controller.model.TeacherDTO;
import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Teacher;
import ru.noleg.crmmm.messages.GeneralMessages;
import ru.noleg.crmmm.service.TeacherService;
import ru.noleg.crmmm.utils.ValidationUtils;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("v1/teachers")
public class TeacherController {
    private final ValidationUtils validator;
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;
    private final LessonMapper lessonMapper;

    public TeacherController(ValidationUtils validator, TeacherService teacherService, TeacherMapper teacherMapper, LessonMapper lessonMapper) {
        this.validator = validator;
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
        this.lessonMapper = lessonMapper;
    }

    @PostMapping
    public ResponseEntity<?> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        this.validator.validationRequest(teacherDTO);

        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        this.teacherService.createTeacher(teacher);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long id,
                                                    @RequestBody TeacherDTO teacherDTO) {
        this.validator.validationRequest(teacherDTO);

        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        Teacher teacherUpdated = this.teacherService.updateTeacher(id, teacher);
        TeacherDTO teacherDtoUpdated = teacherMapper.toDto(teacherUpdated);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(teacherDtoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {

        this.teacherService.deleteTeacher(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacher(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {
        Teacher teacher = this.teacherService.getTeacherById(id);
        TeacherDTO teacherDTO = teacherMapper.toDto(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(teacherDTO);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getTeachers() {
        Collection<Teacher> teachers = this.teacherService.getTeachers();
        List<TeacherDTO> teacherDTOS = this.teacherMapper.toDtos(teachers);
        return ResponseEntity.status(HttpStatus.OK).body(teacherDTOS);
    }

    @GetMapping("/lessons")
    public ResponseEntity<List<LessonDTO>> getLessonsByTeacher(@RequestParam @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long teacherId) {

        List<Lesson> lessons = this.teacherService.getLessonsByTeacherId(teacherId);
        List<LessonDTO> lessonDTOS = this.lessonMapper.toDtos(lessons);
        return ResponseEntity.status(HttpStatus.OK).body(lessonDTOS);

    }
}
