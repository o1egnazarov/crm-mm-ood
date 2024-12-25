package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.ParentDTO;
import ru.noleg.crmmm.entity.ParentEntity;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface ParentMapper extends BaseMapper<ParentEntity, ParentDTO> {
    @Override
    ParentEntity toEntity(ParentDTO parentDTO);

    @Override
    ParentDTO toDto(ParentEntity parentEntity);

    @Override
    ParentEntity updateEntity(ParentDTO parentDTO, ParentEntity parentEntity);

    @Override
    List<ParentEntity> toEntities(Collection<ParentDTO> parentDTOS);

    @Override
    List<ParentDTO> toDtos(Collection<ParentEntity> ts);
}
