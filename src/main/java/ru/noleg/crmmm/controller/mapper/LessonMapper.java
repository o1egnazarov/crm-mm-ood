package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.LessonDTO;
import ru.noleg.crmmm.controller.model.StudentDTO;
import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Map;
import java.util.stream.Collectors;

@Mapper(config = MapStructConfig.class, uses = {StudentMapper.class})
public interface LessonMapper extends BaseMapper<Lesson, LessonDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Lesson toEntity(LessonDTO lessonDTO);

    @Override
    LessonDTO toDto(Lesson lesson);

    @Override
    @Mapping(target = "id", ignore = true)
    Lesson updateEntity(LessonDTO lessonDTO, @MappingTarget Lesson lessonEntity);

    StudentDTO toDto(Student student);

    Student toEntity(StudentDTO studentDTO);

    default Map<StudentDTO, Boolean> toEntityMapAttendance(Map<Student, Boolean> attendance) {
        if (attendance == null) {
            return null;
        }
        return attendance.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> toDto(entry.getKey()),
                        Map.Entry::getValue
                ));
    }

    default Map<Student, Boolean> toDtoMapAttendance(Map<StudentDTO, Boolean> attendance) {
        if (attendance == null) {
            return null;
        }
        return attendance.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> toEntity(entry.getKey()),
                        Map.Entry::getValue
                ));
    }
}
