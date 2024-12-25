package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.exception.GroupNotFoundException;
import ru.noleg.crmmm.messages.GroupMessages;
import ru.noleg.crmmm.repository.GroupRepository;
import ru.noleg.crmmm.service.GroupService;
import ru.noleg.crmmm.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

@Service
public class GroupServiceDefaultImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final StudentService studentService;

    public GroupServiceDefaultImpl(GroupRepository groupRepository, StudentService studentService) {
        this.groupRepository = groupRepository;
        this.studentService = studentService;
    }

    @Override
    public void createGroup(Group group) {
        this.groupRepository.save(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(
                () -> new GroupNotFoundException(String.format(GroupMessages.GROUP_ERROR_NOT_EXIST, id))
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

    @Override
    public Group addStudentToGroup(Long studentId, Long groupId) {
        Group group = getGroupById(groupId);
        Student student = this.studentService.getStudentById(studentId);

        List<Student> students = group.getStudents();
        if (!students.contains(student)) {
            students.add(student);
            student.setGroup(group);
        }


        Group updatedGroup = new Group(
                group.getId(),
                group.getTitle(),
                students,
                group.getSchedule(),
                group.getTeacher()
        );
        studentService.updateStudent(studentId, student);
        groupRepository.save(updatedGroup);

        return updatedGroup;
    }

    @Override
    public Group removeStudentFromGroup(Long studentId, Long groupId) {
        Group group = getGroupById(groupId);
        Student student = this.studentService.getStudentById(studentId);

        List<Student> students = group.getStudents();
        students.remove(student);
        student.setGroup(null);

        // Сохраняем изменения
        Group updatedGroup = new Group(
                group.getId(),
                group.getTitle(),
                students,
                group.getSchedule(),
                group.getTeacher()
        );
        groupRepository.save(updatedGroup);
        return updatedGroup;
    }

    @Override
    public List<Student> getStudentByGroupId(Long id) {
        return StreamSupport.stream(this.groupRepository.findAll().spliterator(), false)
                .filter(group -> group.getId() != null && Objects.equals(group.getId(), id))
                .map(Group::getStudents)
                .flatMap(Collection::stream)
                .toList();
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
