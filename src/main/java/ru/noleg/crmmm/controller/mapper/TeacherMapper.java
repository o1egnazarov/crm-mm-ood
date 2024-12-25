package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.TeacherDTO;
import ru.noleg.crmmm.entity.TeacherEntity;
import ru.noleg.crmmm.utils.BaseMapper;

@Mapper(config = MapStructConfig.class)
public interface TeacherMapper extends BaseMapper<TeacherEntity, TeacherDTO> {
    @Override
    TeacherEntity toEntity(TeacherDTO teacherDTO);

    @Override
    @Mapping(target = "id", ignore = true)
    TeacherEntity updateEntity(TeacherDTO teacherDTO, TeacherEntity teacherEntity);

}
