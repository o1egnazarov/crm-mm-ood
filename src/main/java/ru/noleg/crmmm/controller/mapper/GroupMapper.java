package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.GroupDTO;
import ru.noleg.crmmm.entity.Group;
import ru.noleg.crmmm.utils.BaseMapper;

@Mapper(config = MapStructConfig.class, uses = {StudentMapper.class, LessonMapper.class})
public interface GroupMapper extends BaseMapper<Group, GroupDTO> {
    @Override
    Group toEntity(GroupDTO groupDTO);

    @Override
    GroupDTO toDto(Group group);

    @Override
    Group updateEntity(GroupDTO groupDTO, @MappingTarget Group group);
}
