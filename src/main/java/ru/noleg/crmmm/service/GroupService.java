package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.Student;


import java.util.List;

public interface GroupService {
    Group createGroup(Group group);
    Group getGroupById(Long id);
    List<Group> getAllGroups();
    Group updateGroup(Long id, Group group);
    void deleteGroup(Long id);

    void addStudentToGroup(Student student, Long groupId);

    void removeStudentFromGroup(Student student, Long groupId);
}
