package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.repository.GroupRepository;
import ru.noleg.crmmm.service.GroupService;

@Service
public class GroupServiceDefaultImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceDefaultImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
