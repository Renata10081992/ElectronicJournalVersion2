package com.mustafina.springcourse.ProjectDiary.controller;

import com.mustafina.springcourse.ProjectDiary.model.Class_;
import com.mustafina.springcourse.ProjectDiary.model.Pupil;
import com.mustafina.springcourse.ProjectDiary.service.ClassServ;
import com.mustafina.springcourse.ProjectDiary.service.MarkServ;
import com.mustafina.springcourse.ProjectDiary.service.PupilServ;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/pupil")
public class PupilController {

    private final PupilServ pupilServ;
    private final ClassServ classServ;
    private final MarkServ markServ;

    @Autowired
    public PupilController(PupilServ pupilServ, ClassServ classServ, MarkServ markServ) {
        this.pupilServ = pupilServ;
        this.classServ = classServ;
        this.markServ = markServ;
    }

    @GetMapping()
    public String getPupilsByClass(@RequestParam int classId, Model model) {
        model.addAttribute("oneClass", classServ.findById(classId));
        model.addAttribute("pupilsByClass", pupilServ.findPupilsByClassId(classId));
        return "classes/pupilByClass";
    }
   @GetMapping("/{id}")
    public String getOnePupil(@PathVariable("id") int id, Model model) {
    model.addAttribute("onePupil", pupilServ.findById(id));
       return ("pupils/onePupil");
  }

    @GetMapping("/new")
    public String newPupil(@RequestParam Integer classId, Model model) {
        Pupil newPupil = new Pupil();
        model.addAttribute("newPupil", newPupil);
        model.addAttribute("classId", classId);
        return "pupils/new";
    }

    @PostMapping()
    public String createPupil(@ModelAttribute("newPupil") @Valid Pupil pupil, BindingResult bindingResult, @RequestParam Integer classId) {
        if(bindingResult.hasErrors())
            return "pupils/new";
        pupilServ.create(pupil, classId);
        return "redirect:/pupil?classId=" + pupil.getClass_().getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@RequestParam Integer classId, @PathVariable("id") int id) {
        pupilServ.deleteById(id);
        return "redirect:/pupil?classId=" + classId;
    }
}
