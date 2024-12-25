package ru.noleg.crmmm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.GroupEntity;
import ru.noleg.crmmm.repository.GroupRepository;
import ru.noleg.crmmm.service.GroupService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceDefaultImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public GroupEntity createGroup(GroupEntity group) {
        return groupRepository.save(group);
    }

    @Override
    public GroupEntity getGroupById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));
    }

    @Override
    public List<GroupEntity> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public GroupEntity updateGroup(Long id, GroupEntity group) {
        GroupEntity existingGroup = getGroupById(id);
        existingGroup.setName(group.getName());
        existingGroup.setTeacher(group.getTeacher());
        existingGroup.setStudents(group.getStudents());
        return groupRepository.save(existingGroup);
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
