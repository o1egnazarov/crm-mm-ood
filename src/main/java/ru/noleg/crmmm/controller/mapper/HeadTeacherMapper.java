package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.HeadTeacherDTO;
import ru.noleg.crmmm.entity.HeadTeacher;
import ru.noleg.crmmm.utils.BaseMapper;

@Mapper(config = MapStructConfig.class, uses = {TeacherMapper.class})
public interface HeadTeacherMapper extends BaseMapper<HeadTeacher, HeadTeacherDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    HeadTeacher toEntity(HeadTeacherDTO headTeacherDTO);

    @Override
    HeadTeacherDTO toDto(HeadTeacher headTeacher);

    @Override
    @Mapping(target = "id", ignore = true)
    HeadTeacher updateEntity(HeadTeacherDTO headTeacherDTO, @MappingTarget HeadTeacher headTeacher);

}
