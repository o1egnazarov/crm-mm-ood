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
import ru.noleg.crmmm.controller.mapper.GroupMapper;
import ru.noleg.crmmm.controller.mapper.StudentMapper;
import ru.noleg.crmmm.controller.model.GroupDTO;
import ru.noleg.crmmm.controller.model.StudentDTO;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.messages.GeneralMessages;
import ru.noleg.crmmm.service.GroupService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("v1/groups")
public class GroupController {

    private final GroupService groupService;
    private final GroupMapper groupMapper;
    private final StudentMapper studentMapper;

    public GroupController(GroupService groupService, GroupMapper groupMapper, StudentMapper studentMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
        this.studentMapper = studentMapper;
    }


    @PostMapping
    public ResponseEntity<?> createGroup(@RequestBody GroupDTO groupDTO) {
        Group group = groupMapper.toEntity(groupDTO);
        this.groupService.createGroup(group);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {
        this.groupService.deleteGroup(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupDTO> updateGroup(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long id,
                                                @RequestBody GroupDTO groupDTO) {

        Group group = groupMapper.toEntity(groupDTO);
        Group groupUpdated = this.groupService.updateGroup(id, group);
        GroupDTO groupDtoUpdated = groupMapper.toDto(groupUpdated);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupDtoUpdated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {
        Group group = this.groupService.getGroupById(id);
        GroupDTO groupDTO = groupMapper.toDto(group);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupDTO);
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getGroups() {
        Collection<Group> teachers = this.groupService.getGroups();
        List<GroupDTO> groupDTOS = this.groupMapper.toDtos(teachers);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupDTOS);
    }

    @PostMapping("/{groupId}/students/{studentId}")
    public ResponseEntity<GroupDTO> addStudentToGroup(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long groupId,
                                                      @PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long studentId) {

        Group group = this.groupService.addStudentToGroup(studentId, groupId);
        GroupDTO groupDTO = groupMapper.toDto(group);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupDTO);

    }

    @DeleteMapping("/{groupId}/students/{studentId}")
    public ResponseEntity<GroupDTO> deleteStudentToGroup(@PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long groupId,
                                                         @PathVariable @Positive(message = GeneralMessages.NOT_VALID_ID) Long studentId) {

        Group group = this.groupService.removeStudentFromGroup(studentId, groupId);
        GroupDTO groupDTO = groupMapper.toDto(group);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupDTO);

    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<StudentDTO>> getStudentByGroup(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {

        List<Student> students = this.groupService.getStudentByGroupId(id);
        List<StudentDTO> studentDTOS = this.studentMapper.toDtos(students);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentDTOS);

    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<List<GroupDTO>> getGroupsByTeacher(@PathVariable @Positive
            (message = GeneralMessages.NOT_VALID_ID) Long id) {

        List<Group> groups = this.groupService.getGroupsByTeacher(id);
        List<GroupDTO> groupDTOS = this.groupMapper.toDtos(groups);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupDTOS);

    }


}
