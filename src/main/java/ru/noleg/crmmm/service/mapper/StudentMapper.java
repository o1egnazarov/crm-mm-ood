package ru.noleg.crmmm.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.entity.StudentEntity;
import ru.noleg.crmmm.repository.model.Student;
import ru.noleg.crmmm.utils.BaseMapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface StudentMapper extends BaseMapper<Student, StudentEntity> {
    @Override
    Student toEntity(StudentEntity studentEntity);

    @Override
    StudentEntity toDto(Student student);

    @Override
    @Mapping(target = "id", ignore = true)
    Student updateEntity(StudentEntity studentEntity, Student student);

    @Override
    List<Student> toEntities(Collection<StudentEntity> studentEntities);

    @Override
    List<StudentEntity> toDtos(Collection<Student> ts);
}
