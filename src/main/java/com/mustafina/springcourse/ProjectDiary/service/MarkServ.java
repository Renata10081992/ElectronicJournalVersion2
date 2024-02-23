package com.mustafina.springcourse.ProjectDiary.service;

import com.mustafina.springcourse.ProjectDiary.model.Mark;
import com.mustafina.springcourse.ProjectDiary.model.Pupil;
import com.mustafina.springcourse.ProjectDiary.model.Subject;
import com.mustafina.springcourse.ProjectDiary.repository.MarkRepos;
import com.mustafina.springcourse.ProjectDiary.repository.PupilRepos;
import com.mustafina.springcourse.ProjectDiary.repository.SubjectRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServ {

    private MarkRepos markRepos;

    private PupilRepos pupilRepos;

    private SubjectRepos subjectRepos;

    @Autowired
    public MarkServ(MarkRepos markRepos) {
        this.markRepos = markRepos;
    }

    public List<Mark> findMarkByPupilIdAndSubId(int pupilId, int subId) {
//        Pupil pupil=pupilRepos.findById(pupilId).orElse(null);
//        Subject subject= subjectRepos.findById(subId).orElse(null);
        Pupil pupil = new Pupil();
        pupil.setId(pupilId);
        Subject subject = new Subject();
        subject.setId(subId);
        return markRepos.findMarksByPupilIsAndSubjectIs(pupil, subject);
    }

    public void create(Mark mark, Integer subjectId, Integer pupilId) {
        Subject subject = new Subject();
        subject.setId(subjectId);
        Pupil pupil = new Pupil();
        pupil.setId(pupilId);
        mark.setPupil(pupil);
        mark.setSubject(subject);
        markRepos.save(mark);
    }
}
