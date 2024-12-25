package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.GroupDTO;
import ru.noleg.crmmm.entity.GroupEntity;
import ru.noleg.crmmm.utils.BaseMapper;

@Mapper(config = MapStructConfig.class)
public interface GroupMapper extends BaseMapper<GroupEntity, GroupDTO> {
    @Override
    GroupEntity toEntity(GroupDTO groupDTO);

    @Override
    @Mapping(target = "id", ignore = true)
    GroupEntity updateEntity(GroupDTO groupDTO, GroupEntity groupEntity);
}
