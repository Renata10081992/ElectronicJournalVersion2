package com.mustafina.springcourse.ProjectDiary.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Subject")
public class Subject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "subjects")
    private List<Class_> classes;

    @OneToMany(mappedBy = "subject")
    private List<Mark> marks;

    public Subject(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Subject() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Class_> getClasses() {
        return classes;
    }

    public void setClasses(List<Class_> classes) {
        this.classes = classes;
    }

    public List<Mark> getMark() {
        return marks;
    }

    public void setMark(List<Mark> marks) {
        this.marks = marks;
    }
}
