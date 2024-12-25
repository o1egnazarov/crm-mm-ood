package ru.noleg.crmmm.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.entity.LessonEntity;
import ru.noleg.crmmm.repository.model.Lesson;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface LessonMapper extends BaseMapper<Lesson, LessonEntity> {
    @Override
    Lesson toEntity(LessonEntity lessonEntity);

    @Override
    LessonEntity toDto(Lesson lesson);

    @Override
    @Mapping(target = "id", ignore = true)
    Lesson updateEntity(LessonEntity lessonEntity, Lesson lesson);

    @Override
    List<Lesson> toEntities(Collection<LessonEntity> lessonEntities);

    @Override
    List<LessonEntity> toDtos(Collection<Lesson> ts);
}
