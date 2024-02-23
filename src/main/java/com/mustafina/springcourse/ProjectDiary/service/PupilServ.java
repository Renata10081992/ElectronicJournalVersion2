package com.mustafina.springcourse.ProjectDiary.service;

import com.mustafina.springcourse.ProjectDiary.model.Class_;
import com.mustafina.springcourse.ProjectDiary.model.Pupil;
import com.mustafina.springcourse.ProjectDiary.repository.ClassRepos;
import com.mustafina.springcourse.ProjectDiary.repository.PupilRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PupilServ {

    private final PupilRepos pupilRepos;
    private final ClassRepos classRepos;

    @Autowired
    public PupilServ(PupilRepos pupilRepos, ClassRepos classRepos) {
        this.pupilRepos = pupilRepos;
        this.classRepos = classRepos;
    }

    public List<Pupil> findAll() {
        return pupilRepos.findAll();
    }

    public Pupil findById(int id) {
        return pupilRepos.findById(id).orElse(null);
    }

    public List<Pupil> findPupilsByClassId(int classId) {
        Class_ class_ = classRepos.findById(classId).orElse(null);
        return class_.getPupils();
    }

    public void create(Pupil pupil, Integer classId) {
        Class_ class_ = new Class_();
        class_.setId(classId);
        pupil.setClass_(class_);
        pupilRepos.save(pupil);
    }

    public void deleteById(int id) {
        pupilRepos.deleteById(id);
    }
}
