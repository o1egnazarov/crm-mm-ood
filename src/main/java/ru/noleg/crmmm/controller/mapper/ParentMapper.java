package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.ParentDTO;
import ru.noleg.crmmm.entity.Parent;
import ru.noleg.crmmm.utils.BaseMapper;

@Mapper(config = MapStructConfig.class)
public interface ParentMapper extends BaseMapper<Parent, ParentDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Parent toEntity(ParentDTO parentDTO);

    @Override
    ParentDTO toDto(Parent parent);

    @Override
    @Mapping(target = "id", ignore = true)
    Parent updateEntity(ParentDTO parentDTO, @MappingTarget Parent parentEntity);

}
