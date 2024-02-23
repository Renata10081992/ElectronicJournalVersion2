package com.mustafina.springcourse.ProjectDiary.repository;

import com.mustafina.springcourse.ProjectDiary.model.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PupilRepos extends JpaRepository < Pupil, Integer> {

}
