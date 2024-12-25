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
import ru.noleg.crmmm.controller.model.LessonDTO;
import ru.noleg.crmmm.controller.model.StudentDTO;
import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.messages.GeneralMessages;
import ru.noleg.crmmm.service.LessonService;
import ru.noleg.crmmm.utils.ValidationUtils;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/lessons")
public class LessonController {
    private final ValidationUtils validator;
    private final LessonService lessonService;
    private final LessonMapper lessonMapper;

    public LessonController(ValidationUtils validator, LessonService lessonService, LessonMapper lessonMapper) {
        this.validator = validator;
        this.lessonService = lessonService;
        this.lessonMapper = lessonMapper;
    }


    @PostMapping
    public ResponseEntity<?> createLesson(@RequestBody LessonDTO lessonDTO) {
        this.validator.validationRequest(lessonDTO);

        Lesson lesson = lessonMapper.toEntity(lessonDTO);
        this.lessonService.createLesson(lesson);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonDTO> updateLesson(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long id,
                                                  @RequestBody LessonDTO lessonDTO) {
        this.validator.validationRequest(lessonDTO);

        Lesson lesson = lessonMapper.toEntity(lessonDTO);
        Lesson lessonUpdated = this.lessonService.updateLesson(id, lesson);
        LessonDTO lessonDtoUpdated = lessonMapper.toDto(lessonUpdated);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lessonDtoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLesson(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {

        this.lessonService.deleteLesson(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDTO> getLesson(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {
        Lesson lesson = this.lessonService.getLessonById(id);
        LessonDTO lessonDTO = lessonMapper.toDto(lesson);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lessonDTO);
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<List<LessonDTO>> getLessonsByTeacher(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {

        List<Lesson> lessons = this.lessonService.getLessonsByTeacherId(id);
        List<LessonDTO> lessonDTOS = this.lessonMapper.toDtos(lessons);
        return ResponseEntity.status(HttpStatus.OK).body(lessonDTOS);

    }
//    @PostMapping("/{id}/attendance")
//    public ResponseEntity<Map<StudentDTO,Boolean>> markAttendance(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long id,
//                                                                  @RequestBody Map<StudentDTO, Boolean> attendance) {
//
//
//    }
}
