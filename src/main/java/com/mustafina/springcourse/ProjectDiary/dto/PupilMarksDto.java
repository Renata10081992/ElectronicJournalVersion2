package com.mustafina.springcourse.ProjectDiary.dto;

import com.mustafina.springcourse.ProjectDiary.model.Mark;
import com.mustafina.springcourse.ProjectDiary.model.Pupil;

import java.util.ArrayList;
import java.util.List;

public class PupilMarksDto {
    private Pupil pupil;
    private List<Mark> marks = new ArrayList<>();

    private String gpa;

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }
}
