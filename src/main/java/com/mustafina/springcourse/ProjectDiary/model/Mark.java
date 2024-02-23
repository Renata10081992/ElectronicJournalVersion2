package com.mustafina.springcourse.ProjectDiary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


@Entity
@Table(name = "Mark")
public class Mark {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mark_value")
    @Min(value = 2, message = "от 2-5")
    @Max(value = 5, message = "от 2-5")
    private Integer markValue;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne
    @JoinColumn (name = "pupil_id", referencedColumnName = "id")
    private Pupil pupil;

    public Mark() {
    }

    public Mark(Integer markValue, Subject subject, Pupil pupil) {
        this.markValue = markValue;
        this.subject = subject;
        this.pupil = pupil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMarkValue() {
        return markValue;
    }

    public void setMarkValue(Integer markValue) {
        this.markValue = markValue;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }
}
