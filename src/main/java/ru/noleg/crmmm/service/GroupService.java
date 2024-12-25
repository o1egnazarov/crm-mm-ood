package ru.noleg.crmmm.service;

import ru.noleg.crmmm.entity.GroupEntity;

import java.util.List;

public interface GroupService {
    GroupEntity createGroup(GroupEntity group);
    GroupEntity getGroupById(Long id);
    List<GroupEntity> getAllGroups();
    GroupEntity updateGroup(Long id, GroupEntity group);
    void deleteGroup(Long id);
}
