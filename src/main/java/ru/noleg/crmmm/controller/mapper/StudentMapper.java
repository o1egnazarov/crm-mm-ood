package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.StudentDTO;
import ru.noleg.crmmm.entity.StudentEntity;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface StudentMapper extends BaseMapper<StudentEntity, StudentDTO> {
    @Override
    StudentEntity toEntity(StudentDTO studentDTO);

    @Override
    StudentDTO toDto(StudentEntity studentEntity);

    @Override
    StudentEntity updateEntity(StudentDTO studentDTO, StudentEntity studentEntity);

    @Override
    List<StudentEntity> toEntities(Collection<StudentDTO> studentDTOS);

    @Override
    List<StudentDTO> toDtos(Collection<StudentEntity> ts);
}
