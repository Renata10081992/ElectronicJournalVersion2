package com.mustafina.springcourse.ProjectDiary.controller;

import com.mustafina.springcourse.ProjectDiary.dto.PupilMarksDto;
import com.mustafina.springcourse.ProjectDiary.model.Mark;
import com.mustafina.springcourse.ProjectDiary.model.Pupil;
import com.mustafina.springcourse.ProjectDiary.model.Subject;
import com.mustafina.springcourse.ProjectDiary.service.ClassServ;
import com.mustafina.springcourse.ProjectDiary.service.MarkServ;
import com.mustafina.springcourse.ProjectDiary.service.PupilServ;
import com.mustafina.springcourse.ProjectDiary.service.SubjectServ;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mark")
public class MarkController {

    private final MarkServ markServ;
    private final PupilServ pupilServ;
    private final ClassServ classServ;
    private final SubjectServ subjectServ;

    @Autowired
    public MarkController(MarkServ markServ, PupilServ pupilServ, ClassServ classServ, SubjectServ subjectServ) {
        this.markServ = markServ;
        this.pupilServ = pupilServ;
        this.classServ = classServ;
        this.subjectServ = subjectServ;
    }

    @GetMapping
    public String getMarksByClassAndSubId(@RequestParam("classId") int classId,
                                          @RequestParam("subjectId") Integer subjectId, Model model) {
        model.addAttribute("oneClass", classServ.findById(classId));
        model.addAttribute("subject", subjectServ.findById(subjectId));
        List<Pupil> pupils = pupilServ.findPupilsByClassId(classId);

        List<PupilMarksDto> pupilMarksDtos = new ArrayList<>();
        for (Pupil pupil : pupils) {
            PupilMarksDto pupilMarksDto = new PupilMarksDto();
            pupilMarksDto.setPupil(pupil);
            pupilMarksDto.setMarks(pupil.getMarks());
            double sum = 0;
            for (Mark mark : pupilMarksDto.getMarks()) {
                sum += mark.getMarkValue();
            }
            pupilMarksDto.setGpa(!pupilMarksDto.getMarks().isEmpty() ? String.format("%,.2f", sum / pupilMarksDto.getMarks().size()) : "0");
            pupilMarksDtos.add(pupilMarksDto);
        }
        model.addAttribute("pupilMarksMapping", pupilMarksDtos);
        model.addAttribute("newMark", new Mark());
        return ("marks/markListByClassAndSubject");
    }

    @PostMapping
    public String create(@ModelAttribute("newMark") @Valid Mark mark, @RequestParam Integer subjectId,
                         @RequestParam Integer pupilId, BindingResult bindingResult,
                         @RequestHeader(value = HttpHeaders.REFERER, required = false) final String referrer) {
        if (bindingResult.hasErrors()) {
            return "redirect:" + referrer;
        }
        markServ.create(mark, subjectId, pupilId);
        return "redirect:" + referrer;
    }
}
