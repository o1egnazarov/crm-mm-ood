package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.LessonDTO;
import ru.noleg.crmmm.entity.Lesson;
import ru.noleg.crmmm.utils.BaseMapper;

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
}
