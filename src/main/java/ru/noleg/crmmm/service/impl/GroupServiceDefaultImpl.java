package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.repository.GroupRepository;
import ru.noleg.crmmm.service.GroupService;

import java.util.List;

@Service
public class GroupServiceDefaultImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceDefaultImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group createGroup(Group group) {
        return null;
    }

    @Override
    public Group getGroupById(Long id) {
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return List.of();
    }

    @Override
    public Group updateGroup(Long id, Group group) {
        return null;
    }

    @Override
    public void deleteGroup(Long id) {

    }
}
