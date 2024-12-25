package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.exception.GroupNotFoundException;
import ru.noleg.crmmm.messages.GroupMessages;
import ru.noleg.crmmm.repository.GroupRepository;
import ru.noleg.crmmm.service.GroupService;

import java.util.Collection;
import java.util.List;

@Service
public class GroupServiceDefaultImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceDefaultImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void createGroup(Group group) {
        this.groupRepository.save(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(
                () -> new GroupNotFoundException(String.format(GroupMessages.GROUP_NOT_EXIST, id))
        );
    }

    @Override
    public void deleteGroup(Long id) {
        Group existingGroup = getGroupById(id);
        groupRepository.delete(existingGroup);
    }

    @Override
    public Group updateGroup(Long id, Group updatedGroup) {
        Group existingGroup = getGroupById(id);
        mapUpdatedFields(existingGroup, updatedGroup);

        return groupRepository.save(existingGroup);
    }

    private void mapUpdatedFields(Group existingGroup, Group updatedGroup) {
        existingGroup.setTitle(updatedGroup.getTitle());
        existingGroup.setTeacher(updatedGroup.getTeacher());

        existingGroup.getStudents().clear();
        existingGroup.getStudents().addAll(updatedGroup.getStudents());

        existingGroup.getSchedule().clear();
        existingGroup.getSchedule().addAll(updatedGroup.getSchedule());
    }

    @Override
    public Collection<Group> getGroups() {
        return (List<Group>) groupRepository.findAll();
    }

}
