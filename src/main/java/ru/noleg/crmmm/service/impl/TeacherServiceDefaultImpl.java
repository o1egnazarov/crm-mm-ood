package ru.noleg.crmmm.service.impl;

import org.springframework.stereotype.Service;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Teacher;
import ru.noleg.crmmm.exception.TeacherNotFoundException;
import ru.noleg.crmmm.messages.TeacherMessages;
import ru.noleg.crmmm.repository.TeacherRepository;
import ru.noleg.crmmm.service.TeacherService;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class TeacherServiceDefaultImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceDefaultImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {

        return this.teacherRepository.findById(id).orElseThrow(
                () -> new TeacherNotFoundException(String.format(TeacherMessages.TEACHER_NOT_EXIST, id))
        );

    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher teacher = this.getTeacherById(id);
        this.teacherRepository.delete(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        Teacher existingTeacher = getTeacherById(id);
        mapUpdatedFields(existingTeacher, updatedTeacher);

        return teacherRepository.save(existingTeacher);
    }


    private void mapUpdatedFields(Teacher existingTeacher, Teacher updatedTeacher) {
        if (updatedTeacher.getSurname() != null && !updatedTeacher.getSurname().isEmpty()) {
            existingTeacher.setSurname(updatedTeacher.getSurname());
        }
        if (updatedTeacher.getName() != null && !updatedTeacher.getName().isEmpty()) {
            existingTeacher.setName(updatedTeacher.getName());
        }
        if (updatedTeacher.getPatronymic() != null && !updatedTeacher.getPatronymic().isEmpty()) {
            existingTeacher.setPatronymic(updatedTeacher.getPatronymic());
        }
        if (updatedTeacher.getGroups() != null && !updatedTeacher.getGroups().isEmpty()) {
            updateGroups(existingTeacher, updatedTeacher.getGroups());
        }
    }

    private void updateGroups(Teacher existingTeacher, List<Group> updatedGroups) {
        existingTeacher.getGroups().clear();
        existingTeacher.getGroups().addAll(updatedGroups);
    }

    @Override
    public Collection<Teacher> getTeachers() {
        return (Collection<Teacher>) this.teacherRepository.findAll();

    }

    @Override
    public List<Lesson> getLessonsByTeacherId(Long teacherId) {

        return this.getTeachers().stream()
                .filter(teacher -> Objects.equals(teacher.getId(), teacherId))
                .map(Teacher::getGroups)
                .flatMap(Collection::stream)
                .map(Group::getSchedule)
                .flatMap(Collection::stream)
                .toList();

    }
}
