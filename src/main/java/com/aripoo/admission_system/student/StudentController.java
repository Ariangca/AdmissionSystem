package com.aripoo.admission_system.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/student_list")
    public String getStudents(Model model) {

        model.addAttribute("student_list", studentService.getStudents());
        return "student/student_list";
    }

    @GetMapping(path = "/student_add")
    public String student_form(Model model) {
        Student student = new Student();
        model.addAttribute("studentData", student);
        return "student/student_add";
    }

    //,headers = {"content-type=text/json"}
    @PostMapping(path = "/student_add")
    public ModelAndView registerNewStudent(@ModelAttribute Student student, Model model) {
        studentService.addNewStudent(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student_list");
        return modelAndView;
    }

    @GetMapping(path = "/student_delete")
    public ModelAndView deleteStudent(@RequestParam(name = "studentId") String studentId) {
        studentService.deleteStudent(Long.parseLong(studentId));
        ModelAndView modelAndView = new ModelAndView("redirect:/student_list");
        return modelAndView;
    }

    @GetMapping(path = "/student_edit/{student_id}")
    public String editStudent(@PathVariable(name = "student_id") String studentId, Model model) {
        model.addAttribute("studentId", studentId);
        return "/student/student_edit";
    }

    @PostMapping(path = "/student_edit/{studentId}")
    public ModelAndView updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String major) {
        studentService.editStudent(studentId, firstName, lastName, address, city, country, phoneNumber, major);
        return new ModelAndView("redirect:/student_list");
    }
}
