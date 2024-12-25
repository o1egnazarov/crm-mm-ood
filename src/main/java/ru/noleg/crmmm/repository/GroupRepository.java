package ru.noleg.crmmm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.noleg.crmmm.repository.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
