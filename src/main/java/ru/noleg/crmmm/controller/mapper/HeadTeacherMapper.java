package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.HeadTeacherDTO;
import ru.noleg.crmmm.entity.HeadTeacherEntity;
import ru.noleg.crmmm.utils.BaseMapper;

@Mapper(config = MapStructConfig.class)
public interface HeadTeacherMapper extends BaseMapper<HeadTeacherEntity, HeadTeacherDTO> {
    @Override
    HeadTeacherEntity toEntity(HeadTeacherDTO headTeacherDTO);

    @Override
    HeadTeacherEntity updateEntity(HeadTeacherDTO headTeacherDTO, HeadTeacherEntity headTeacherEntity);

}
