package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.TeacherDTO;
import ru.noleg.crmmm.entity.Teacher;
import ru.noleg.crmmm.utils.BaseMapper;

@Mapper(config = MapStructConfig.class, uses = {GroupMapper.class})
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Teacher toEntity(TeacherDTO teacherDTO);

    @Override
    TeacherDTO toDto(Teacher teacher);

    @Override
    @Mapping(target = "id", ignore = true)
    Teacher updateEntity(TeacherDTO teacherDTO, @MappingTarget Teacher teacherEntity);

}
