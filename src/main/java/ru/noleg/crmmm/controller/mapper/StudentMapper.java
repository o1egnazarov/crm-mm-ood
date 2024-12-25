package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.StudentDTO;
import ru.noleg.crmmm.entity.Student;
import ru.noleg.crmmm.utils.BaseMapper;

@Mapper(config = MapStructConfig.class, uses = ParentMapper.class)
public interface StudentMapper extends BaseMapper<Student, StudentDTO> {
    @Override
    @Mapping(target = "id", ignore = true)

    Student toEntity(StudentDTO studentDTO);

    @Override
    StudentDTO toDto(Student student);

    @Override
    @Mapping(target = "id", ignore = true)
    Student updateEntity(StudentDTO studentDTO, @MappingTarget Student studentEntity);

}
