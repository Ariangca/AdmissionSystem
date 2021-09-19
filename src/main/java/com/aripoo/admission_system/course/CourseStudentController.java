package com.aripoo.admission_system.course;

import com.aripoo.admission_system.student.Student;
import com.aripoo.admission_system.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class CourseStudentController {

    private final CourseService courseService;
    private final StudentService studentService;


    @Autowired
    public CourseStudentController(StudentService studentService,
                                   CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping(path = "course_student_add")
    public String addCourseToStudentForm(Model model) {
        List<Student> students = this.studentService.getStudents();
        List<Course> courses = this.courseService.getCourses();
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);

        return "course/course_student_add";
    }

    @Transactional
    @PostMapping(path = "course_student_add")
    public ModelAndView addCourseToStudentForm(@RequestParam(name = "studentId") Long studentId,
                                               @RequestParam(name = "courseId") Long courseId) {
        Student student=studentService.getStudentById(studentId);
        Course course=courseService.getCourseById(courseId);
        course.getStudents().add(student);
        student.getCourses().add(course);
        ModelAndView modelAndView = new ModelAndView("redirect:course_list");
        return modelAndView;
    }

}
