package ru.noleg.crmmm.service;

import jakarta.validation.constraints.Positive;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.Student;

import java.util.Collection;
import java.util.List;

public interface GroupService {
    void createGroup(Group group);
    void deleteGroup(Long id);
    Group getGroupById(Long id);
    Collection<Group> getGroups();
    Group updateGroup(Long id, Group group);
    Group addStudentToGroup(Long studentId, Long groupId);
    Group removeStudentFromGroup(Long studentId, Long groupId);

    List<Student> getStudentByGroupId(Long id);
}
