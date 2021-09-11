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

    @GetMapping (path = "/student_list")
    public String getStudents(Model model){
        model.addAttribute("student_list", studentService.getStudents());
        return "student/student_list";
    }

    @GetMapping(path = "/student_add")
    public String student_form(){
        System.out.println("11111111111111111111111111111111111111");
        return "student/student_add";
    }

//,headers = {"content-type=text/json"}
    @PostMapping(path = "/student_add")
    public ModelAndView registerNewStudent(@ModelAttribute Student student, Model model){
        System.out.println("0000000000000000000000000000000000000000");
        studentService.addNewStudent(student);
        return new ModelAndView("redirect:/student_list");
    }

    @DeleteMapping(path = "/edit_student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

//    @PutMapping(path = "/edit_student/{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") Long studentId,
//            @RequestParam(required = false) String firstName,
//            @RequestParam(required = false) String lastName,
//            @RequestParam(required = false) String email,
//            @RequestParam(required = false) LocalDate dob){
//        studentService.updateStudent(studentId, firstName, lastName, email, dob);
//    }
}
