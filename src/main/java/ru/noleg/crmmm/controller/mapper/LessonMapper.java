package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.LessonDTO;
import ru.noleg.crmmm.entity.LessonEntity;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface LessonMapper extends BaseMapper<LessonEntity, LessonDTO> {
    @Override
    LessonEntity toEntity(LessonDTO lessonDTO);

    @Override
    LessonDTO toDto(LessonEntity lessonEntity);

    @Override
    LessonEntity updateEntity(LessonDTO lessonDTO, LessonEntity lessonEntity);

    @Override
    List<LessonEntity> toEntities(Collection<LessonDTO> lessonDTOS);

    @Override
    List<LessonDTO> toDtos(Collection<LessonEntity> ts);
}
