package com.mustafina.springcourse.ProjectDiary.controller;

import com.mustafina.springcourse.ProjectDiary.service.ClassServ;
import com.mustafina.springcourse.ProjectDiary.service.SubjectServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/subject")
public class SubjectController {
    public final SubjectServ subjectServ;
    public final ClassServ classServ;

    @Autowired
    public SubjectController(SubjectServ subjectServ, ClassServ classServ) {
        this.subjectServ = subjectServ;
        this.classServ = classServ;
    }

    @GetMapping()
    public String getSubjects(Model model) {
        model.addAttribute("subjects", subjectServ.findAll());
        return ("subjects/subjectList");
    }
}
