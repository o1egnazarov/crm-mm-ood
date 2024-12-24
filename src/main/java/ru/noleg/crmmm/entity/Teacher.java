package ru.noleg.crmmm.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Teacher {
    private String surname;
    private String name;
    private String patronymic;
    private List<Group> groups;

    public List<Group> addGroup(Group group) {
        this.groups.add(group);
        return groups;
    }

    public void removeGroup(Group group) {
        this.groups.remove(group);
    }
}
