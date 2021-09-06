package com.aripoo.admission_system.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path= "/")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path = "student_list", method = RequestMethod.GET)
    public String getStudent(Model model){
        model.addAttribute("listStudents", studentService.getStudent());
        System.out.println("000000000000000000000000000000000000000000000000000000" +
                "-------------------------------------------------------------");
        return "student_list";
//        return studentService.getStudent();

    }

    @PostMapping(path = "student_add")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "edit_student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "edit_student/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) LocalDate dob){
        studentService.updateStudent(studentId, firstName, lastName, email, dob);
    }
}
