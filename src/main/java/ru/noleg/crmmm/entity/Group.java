package ru.noleg.crmmm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "student_group")

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Lesson> schedule;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Group() {
    }

    public Group(Long id, String s, List<Student> students, List<Lesson> lessons) {
       this.id = id;
       this.title = s;
       this.students = students;
       this.schedule = lessons;
       this.teacher = new Teacher();
    }

    public List<Lesson> addClassToSchedule(Lesson lesson) {
        this.schedule.add(lesson);
        return schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lesson> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Lesson> schedule) {
        this.schedule = schedule;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
