package com.aripoo.admission_system.teacher;

import com.aripoo.admission_system.teacher.Teacher;
import com.aripoo.admission_system.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(path = "/teacher_list")
    public String getTeachers(Model model) {

        model.addAttribute("teacher_list", teacherService.getTeachers());
        return "teacher/teacher_list";
    }

    @GetMapping(path = "/teacher_add")
    public String teacher_form(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacherData", teacher);
        return "teacher/teacher_add";
    }

    //,headers = {"content-type=text/json"}
    @PostMapping(path = "/teacher_add")
    public ModelAndView registerNewTeacher(@ModelAttribute Teacher teacher, Model model) {
        teacherService.addNewTeacher(teacher);
        System.out.println("0000000000000000000000000000000000000000  " );
        ModelAndView modelAndView = new ModelAndView("redirect:/teacher_list");
        return modelAndView;
    }

    @GetMapping(path = "/teacher_delete")
    public ModelAndView deleteTeacher(@RequestParam(name = "teacherId") String teacherId) {
        teacherService.deleteTeacher(Long.parseLong(teacherId));
        ModelAndView modelAndView = new ModelAndView("redirect:/teacher_list");
        return modelAndView;
    }

    @GetMapping(path = "/teacher_edit/{teacher_id}")
    public String editTeacher(@PathVariable(name = "teacher_id") String teacherId, Model model) {
        model.addAttribute("teacherId", teacherId);
        return "/teacher/teacher_edit";
    }

    @PostMapping(path = "/teacher_edit/{teacherId}")
    public ModelAndView updateTeacher(
            @PathVariable("teacherId") Long teacherId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) Long salary) {
        teacherService.editTeacher(teacherId, firstName, lastName, address, city, country, phoneNumber, salary);
        return new ModelAndView("redirect:/teacher_list");
    }
}
