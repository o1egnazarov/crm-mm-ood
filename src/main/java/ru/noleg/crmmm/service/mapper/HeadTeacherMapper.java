package ru.noleg.crmmm.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.entity.HeadTeacherEntity;
import ru.noleg.crmmm.repository.model.HeadTeacher;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface HeadTeacherMapper extends BaseMapper<HeadTeacher, HeadTeacherEntity> {
    @Override
    HeadTeacher toEntity(HeadTeacherEntity headTeacherEntity);

    @Override
    HeadTeacherEntity toDto(HeadTeacher headTeacher);

    @Override
    @Mapping(target = "id", ignore = true)
    HeadTeacher updateEntity(HeadTeacherEntity headTeacherEntity, HeadTeacher headTeacher);

    @Override
    List<HeadTeacher> toEntities(Collection<HeadTeacherEntity> headTeacherEntities);

    @Override
    List<HeadTeacherEntity> toDtos(Collection<HeadTeacher> ts);
}
