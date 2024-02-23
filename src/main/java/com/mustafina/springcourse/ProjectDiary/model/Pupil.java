package com.mustafina.springcourse.ProjectDiary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Pupil")
public class Pupil {

    public Pupil(){};

    public Pupil(String firstname, String lastname, Class_ class_) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.class_= class_;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname")
    @NotEmpty(message = "поле имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Длина должна быть от 2 до 10 символов")
    private String firstname;

    @Column(name = "lastname")
    @NotEmpty(message = "поле фамилия не может быть пустым")
    @Size(min = 2, max = 50, message = "Длина должна быть от 2 до 10 символов")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class_ class_;

    @OneToMany(mappedBy = "pupil", cascade = CascadeType.REMOVE)
    private List<Mark> marks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Class_ getClass_() {
        return class_;
    }

    public void setClass_(Class_ class_) {
        this.class_ = class_;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
}
