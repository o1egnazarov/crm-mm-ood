package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.entity.Teacher;
import ru.noleg.crmmm.exception.HeadTeacherNotFoundException;
import ru.noleg.crmmm.repository.HeadTeacherRepository;
import ru.noleg.crmmm.service.GroupService;
import ru.noleg.crmmm.service.HeadTeacherService;
import ru.noleg.crmmm.service.TeacherService;

import java.util.List;

@Service
public class HeadTeacherServiceDefaultImpl implements HeadTeacherService {
    private final HeadTeacherRepository headTeacherRepository;
    private final TeacherService teacherService;
    private final GroupService groupService;

    public HeadTeacherServiceDefaultImpl(HeadTeacherRepository headTeacherRepository, TeacherService teacherService, GroupService groupService) {
        this.headTeacherRepository = headTeacherRepository;
        this.teacherService = teacherService;
        this.groupService = groupService;
    }

    @Override
    public Long createHeadTeacher(HeadTeacher headTeacher) {
        return headTeacherRepository.save(headTeacher).getId();
    }

    @Override
    public HeadTeacher updateHeadTeacher(Long id, HeadTeacher headTeacher) {
        return null;
    }

    @Override
    public void deleteHeadTeacher(Long id) {
        HeadTeacher existingHeadTeacher = getHeadTeacherById(id);
        headTeacherRepository.delete(existingHeadTeacher);
    }

    @Override
    public HeadTeacher getHeadTeacherById(Long id) {
        return headTeacherRepository.findById(id)
                .orElseThrow(() -> new HeadTeacherNotFoundException("HeadTeacher with id " + id + " not found"));
    }

    @Override
    public Teacher removeGroupFromTeacher(Long teacherId, Long groupId) {
        Teacher teacher = this.teacherService.getTeacherById(teacherId);
        Group group = this.groupService.getGroupById(groupId);

        teacher.getGroups().remove(group);
        group.setTeacher(null);

        this.groupService.updateGroup(groupId, group);
        this.teacherService.updateTeacher(teacherId, teacher);

        return teacher;
    }

    @Override
    public Teacher assignTeacherToGroup(Long teacherId, Long groupId) {
        Teacher teacher = this.teacherService.getTeacherById(teacherId);
        Group group = this.groupService.getGroupById(groupId);

        List<Group> groups = teacher.getGroups();
        if (!groups.contains(group)) {
            groups.add(group);
            teacher.setGroups(groups);
            group.setTeacher(teacher);
        }

        this.groupService.updateGroup(groupId, group);
        this.teacherService.updateTeacher(teacherId, teacher);

        return teacher;
    }
}
