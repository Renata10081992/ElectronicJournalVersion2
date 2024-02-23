package com.mustafina.springcourse.ProjectDiary.repository;

import com.mustafina.springcourse.ProjectDiary.model.Class_;
import com.mustafina.springcourse.ProjectDiary.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepos extends JpaRepository <Class_,Integer> {


}
