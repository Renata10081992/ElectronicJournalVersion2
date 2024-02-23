package com.mustafina.springcourse.ProjectDiary.repository;

import com.mustafina.springcourse.ProjectDiary.model.Mark;
import com.mustafina.springcourse.ProjectDiary.model.Pupil;
import com.mustafina.springcourse.ProjectDiary.model.Subject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepos extends JpaRepository<Mark, Integer> {

    // List<Mark> findMarkByPupilIdAndSubId (int pupilId, int subId);

   Mark save(Mark mark);


    List<Mark> findMarksByPupilIsAndSubjectIs(Pupil pupil, Subject subject);
}
