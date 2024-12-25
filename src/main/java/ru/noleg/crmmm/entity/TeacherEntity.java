package ru.noleg.crmmm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class TeacherEntity {
    private String surname;
    private String name;
    private String patronymic;
    private List<GroupEntity> groupEntities;

    public List<GroupEntity> addGroup(GroupEntity groupEntity) {
        this.groupEntities.add(groupEntity);
        return groupEntities;
    }

    public void removeGroup(GroupEntity groupEntity) {
        this.groupEntities.remove(groupEntity);
    }
}
