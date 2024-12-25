package ru.noleg.crmmm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.noleg.crmmm.controller.mapper.TeacherMapper;
import ru.noleg.crmmm.controller.model.TeacherDTO;
import ru.noleg.crmmm.entity.TeacherEntity;
import ru.noleg.crmmm.service.TeacherService;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @PostMapping
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        TeacherEntity teacher = teacherMapper.toEntity(teacherDTO);

        TeacherEntity createdTeacher = this.teacherService.createTeacher(teacher);

        TeacherDTO createdTeacherDTO = teacherMapper.toDto(createdTeacher);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacherDTO);
    }
}
