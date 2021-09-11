package com.aripoo.admission_system.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.aripoo.admission_system.student.Student;
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
    public String student_form(Model model){
        Student student=new Student();
        model.addAttribute("studentData",student);
        return "student/student_add";
    }

//,headers = {"content-type=text/json"}
    @PostMapping(path = "/student_add")
    public ModelAndView registerNewStudent(@ModelAttribute Student student, Model model){
        studentService.addNewStudent(student);
        ModelAndView modelAndView=new ModelAndView("redirect:/student_list");
        return modelAndView;
    }

    @GetMapping(path = "/student_delete")
    public ModelAndView deleteStudent(@RequestParam(name = "studentId") String studentId) {

        System.out.println("0000000000000000000000000000000000000000");
        studentService.deleteStudent(Long.parseLong(studentId));
        ModelAndView modelAndView=new ModelAndView("redirect:/student_list");
        return modelAndView;
    }
    @GetMapping(path = "/student_edit/{student_id}")
    public String editStudent(){
        return "/student/student_edit";
    }
//    @PutMapping(path = "/student_edit/{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") Long studentId,
//            @RequestParam(required = false) String firstName,
//            @RequestParam(required = false) String lastName,
//            @RequestParam(required = false) String email,
//            @RequestParam(required = false) LocalDate dob){
//        studentService.updateStudent(studentId, firstName, lastName, email, dob);
//    }
}
