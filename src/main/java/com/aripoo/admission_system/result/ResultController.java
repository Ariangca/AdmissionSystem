package com.aripoo.admission_system.result;

import com.aripoo.admission_system.course.Course;
import com.aripoo.admission_system.course.CourseService;
import com.aripoo.admission_system.student.Student;
import com.aripoo.admission_system.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class ResultController {
    private final ResultService resultService;
    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public ResultController(ResultService resultService, StudentService studentService, CourseService courseService) {
        this.resultService = resultService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping(path = "/result_list")
    public String getResults(Model model) {
        model.addAttribute("results", resultService.getResults());
        return "result/result_list";
    }
    @GetMapping(path = "/result_add")
    public String addResultForm(Model model){
        List<Student> students=studentService.getStudents();
        List<Course> courses=courseService.getCourses();
        model.addAttribute("students",students);
        model.addAttribute("courses",courses);
        Result resultData=new Result();
        model.addAttribute("resultData",resultData);
        return "result/result_add";
    }
    @PostMapping(path = "/result_add")
    public ModelAndView addNewResult(@ModelAttribute Result resultData, Model model) {
        System.out.println("0000000000000000000000000000000000000000");
        resultService.addNewResult(resultData);
        return new ModelAndView("redirect:/result_list");
    }

    @GetMapping(path = "/result_delete")
    public ModelAndView deleteResult(@RequestParam Long studentId,@RequestParam Long courseId){
        resultService.deleteResult(studentId,courseId);
        return new ModelAndView("redirect:/result_list");
    }

//    @DeleteMapping(path = "/edit_result/{studentId}/{courseId}")
//    public void deleteResult(@PathVariable Long studentId,@PathVariable Long courseId){
//        resultService.deleteResult(new StudentCourseId(new Student(studentId),new Course(courseId)));
//    }
//
//    @PutMapping(path = "/edit_result/{studentId}/{courseId}")
//    public void updateResult(@PathVariable("studentId") Long studentId,
//                             @PathVariable("courseId") Long courseId,
//                             @RequestParam(required = false) Integer session,
//                             @RequestParam(required = false) Integer mark){
//        resultService.updateResult(studentId, courseId, session, mark);
//    }
}
