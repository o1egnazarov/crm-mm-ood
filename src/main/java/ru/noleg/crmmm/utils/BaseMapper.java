package ru.noleg.crmmm.utils;

import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

public interface BaseMapper<E, T> {
    E toEntity(T t);

    T toDto(E e);

    E updateEntity(T t, @MappingTarget E e);

    List<E> toEntities(Collection<T> ts);

    List<T> toDtos(Collection<E> ts);

}
