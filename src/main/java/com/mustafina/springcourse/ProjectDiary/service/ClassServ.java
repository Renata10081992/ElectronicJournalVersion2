package com.mustafina.springcourse.ProjectDiary.service;

import com.mustafina.springcourse.ProjectDiary.model.Class_;
import com.mustafina.springcourse.ProjectDiary.repository.ClassRepos;
import com.mustafina.springcourse.ProjectDiary.repository.SubjectRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServ {

    private final ClassRepos classRepos;
    private final SubjectRepos subjectRepos;

    @Autowired
    public ClassServ(ClassRepos classRepos, SubjectRepos subjectRepos) {
        this.classRepos = classRepos;
        this.subjectRepos = subjectRepos;
    }

    public List<Class_> findAll() {
      return classRepos.findAll();
    }

    public Class_ findById(int id) {
        return classRepos.findById(id).orElse(null);
    };

 //   поменяли
//    public List<Class_> findClass_sBySubjectsId (int subjectId) {
//        Subject subject= subjectRepos.findById(subjectId).orElse(null);
//        return subject.getClasses();
//    }
}
