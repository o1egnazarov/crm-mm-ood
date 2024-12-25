package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.repository.GroupRepository;
import ru.noleg.crmmm.service.GroupService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GroupServiceDefaultImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceDefaultImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Group with id " + id + " not found"));
    }

    @Override
    public List<Group> getAllGroups() {
        return (List<Group>) groupRepository.findAll();
    }

    @Override
    public Group updateGroup(Long id, Group group) {
        Group existingGroup = getGroupById(id); // Проверяем, существует ли группа

        // Создаем новый объект Group на основе данных из существующей группы и новых данных
        Group updatedGroup = new Group(
                existingGroup.getId(),
                group.getTitle() != null ? group.getTitle() : existingGroup.getTitle(),
                group.getStudents() != null ? group.getStudents() : existingGroup.getStudents(),
                group.getSchedule() != null ? group.getSchedule() : existingGroup.getSchedule()
        );

        return groupRepository.save(updatedGroup);
    }

    @Override
    public void deleteGroup(Long id) {
        Group existingGroup = getGroupById(id); // Проверяем существование группы
        groupRepository.delete(existingGroup);
    }

    @Override
    public void addStudentToGroup(Student student, Long groupId) {
        Group group = getGroupById(groupId); // Проверяем существование группы

        // Добавляем студента в группу
        List<Student> students = group.getStudents();
        if (!students.contains(student)) { // Проверяем, чтобы не добавлять дубликаты
            students.add(student);
        }

        // Сохраняем изменения
        Group updatedGroup = new Group(
                group.getId(),
                group.getTitle(),
                students,
                group.getSchedule()
        );
        groupRepository.save(updatedGroup);
    }

    @Override
    public void removeStudentFromGroup(Student student, Long groupId) {
        Group group = getGroupById(groupId); // Проверяем существование группы

        // Удаляем студента из группы
        List<Student> students = group.getStudents();
        if (students.contains(student)) {
            students.remove(student);
        }

        // Сохраняем изменения
        Group updatedGroup = new Group(
                group.getId(),
                group.getTitle(),
                students,
                group.getSchedule()
        );
        groupRepository.save(updatedGroup);
    }
}
