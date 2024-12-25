package ru.noleg.crmmm.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.GroupDTO;
import ru.noleg.crmmm.entity.GroupEntity;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface GroupMapper extends BaseMapper<GroupEntity, GroupDTO> {
    @Override
    GroupEntity toEntity(GroupDTO groupDTO);

    @Override
    GroupDTO toDto(GroupEntity groupEntity);

    @Override
    @Mapping(target = "id", ignore = true)
    GroupEntity updateEntity(GroupDTO groupDTO, GroupEntity groupEntity);

    @Override
    List<GroupEntity> toEntities(Collection<GroupDTO> groupDTOS);

    @Override
    List<GroupDTO> toDtos(Collection<GroupEntity> ts);
}
