package ru.noleg.crmmm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.noleg.crmmm.repository.GroupRepository;
import ru.noleg.crmmm.service.GroupService;

@Service
@RequiredArgsConstructor
public class GroupServiceDefaultImpl implements GroupService {
    private final GroupRepository groupRepository;
}
