package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Group;

import java.util.Collection;
import java.util.List;

public interface GroupService {
    void createGroup(Group group);
    void deleteGroup(Long id);
    Group getGroupById(Long id);
    Collection<Group> getGroups();
    Group updateGroup(Long id, Group group);
}
