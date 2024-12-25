package ru.noleg.crmmm.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.TeacherDTO;
import ru.noleg.crmmm.entity.TeacherEntity;
import ru.noleg.crmmm.repository.model.Teacher;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface TeacherMapper extends BaseMapper<Teacher, TeacherEntity> {
    @Override
    Teacher toEntity(TeacherEntity teacherEntity);

    @Override
    TeacherEntity toDto(Teacher teacher);

    @Override
    @Mapping(target = "id", ignore = true)
    Teacher updateEntity(TeacherEntity teacherEntity, Teacher teacher);

    @Override
    List<Teacher> toEntities(Collection<TeacherEntity> teacherEntities);

    @Override
    List<TeacherEntity> toDtos(Collection<Teacher> ts);
}
