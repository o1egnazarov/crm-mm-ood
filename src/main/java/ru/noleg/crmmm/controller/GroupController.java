package ru.noleg.crmmm.controller;

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
import ru.noleg.crmmm.controller.model.GroupDTO;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.service.GroupService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("v1/groups")
public class GroupController {

    private final GroupService groupService;
    private final GroupMapper groupMapper;

    public GroupController(GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
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
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        this.groupService.deleteGroup(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

    @PutMapping
    public ResponseEntity<GroupDTO> updateGroup(@PathVariable Long id, @RequestBody GroupDTO groupDTO) {
        Group group = groupMapper.toEntity(groupDTO);
        Group groupUpdated = this.groupService.updateGroup(id, group);
        GroupDTO groupDtoUpdated = groupMapper.toDto(groupUpdated);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupDtoUpdated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable Long id) {
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
}
