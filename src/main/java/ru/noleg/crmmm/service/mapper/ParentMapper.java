package ru.noleg.crmmm.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.entity.ParentEntity;
import ru.noleg.crmmm.repository.model.Parent;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface ParentMapper extends BaseMapper<Parent, ParentEntity> {
    @Override
    Parent toEntity(ParentEntity parentEntity);

    @Override
    ParentEntity toDto(Parent parent);

    @Override
    @Mapping(target = "id", ignore = true)
    Parent updateEntity(ParentEntity parentEntity, Parent parent);

    @Override
    List<Parent> toEntities(Collection<ParentEntity> parentEntities);

    @Override
    List<ParentEntity> toDtos(Collection<Parent> ts);
}
