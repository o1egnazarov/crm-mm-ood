package ru.noleg.crmmm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.noleg.crmmm.entity.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
