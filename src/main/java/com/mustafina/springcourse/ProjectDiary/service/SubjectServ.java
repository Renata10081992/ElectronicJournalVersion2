package com.mustafina.springcourse.ProjectDiary.service;

import com.mustafina.springcourse.ProjectDiary.model.Subject;
import com.mustafina.springcourse.ProjectDiary.repository.SubjectRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServ {

    private SubjectRepos subjectRepos;

    @Autowired
    public SubjectServ(SubjectRepos subjectRepos) {
        this.subjectRepos = subjectRepos;
    }

    public List<Subject> findAll() {
        return subjectRepos.findAll();
    }

    public Subject findById(int id) {
        return subjectRepos.findById(id).orElse(null);
    }
}
