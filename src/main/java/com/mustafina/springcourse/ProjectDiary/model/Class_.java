package com.mustafina.springcourse.ProjectDiary.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Class_")
public class Class_ {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "number")
    private String number;

    @OneToMany(mappedBy = "class_")
    private List <Pupil> pupils;

    @ManyToMany
    @JoinTable(
            name = "subject_to_class",
            joinColumns = @JoinColumn (name = "class_id"),
            inverseJoinColumns = @JoinColumn (name = "subject_id"))
    private List<Subject> subjects;


    public Class_() {
    }

    public Class_(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(List<Pupil> pupils) {
        this.pupils = pupils;
    }
}
