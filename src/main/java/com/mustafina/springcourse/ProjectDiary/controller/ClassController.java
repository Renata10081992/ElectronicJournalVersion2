package com.mustafina.springcourse.ProjectDiary.controller;

import com.mustafina.springcourse.ProjectDiary.model.Subject;
import com.mustafina.springcourse.ProjectDiary.service.ClassServ;
import com.mustafina.springcourse.ProjectDiary.service.SubjectServ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/class")
public class ClassController {

    private final ClassServ classServ;
    private final SubjectServ subjectServ;

    public ClassController(ClassServ classServ, SubjectServ subjectServ) {
        this.classServ = classServ;
        this.subjectServ = subjectServ;
    }

    @GetMapping
    public String getClassesBySubjectId(@RequestParam(required = false) Integer subjectId, Model model) {
        if (subjectId == null) {
            model.addAttribute("classList", classServ.findAll());
            return ("classes/classList");
        }
        Subject subject = subjectServ.findById(subjectId);
        model.addAttribute("oneSubject", subject);
        model.addAttribute("classes", subject.getClasses());
        return ("classes/classesBySubjectId");
    }
}
