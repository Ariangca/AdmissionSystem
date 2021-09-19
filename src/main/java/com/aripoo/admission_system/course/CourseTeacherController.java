package com.aripoo.admission_system.course;

import com.aripoo.admission_system.teacher.Teacher;
import com.aripoo.admission_system.teacher.TeacherService;
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
public class CourseTeacherController {

    private final CourseService courseService;
    private final TeacherService teacherService;


    @Autowired
    public CourseTeacherController(TeacherService teacherService,
                                   CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @GetMapping(path = "course_teacher_add")
    public String addCourseToTeacherForm(Model model) {
        List<Teacher> teachers = this.teacherService.getTeachers();
        List<Course> courses = this.courseService.getCourses();
        model.addAttribute("teachers", teachers);
        model.addAttribute("courses", courses);

        return "course/course_teacher_add";
    }

    @Transactional
    @PostMapping(path = "course_teacher_add")
    public ModelAndView addCourseToTeacherForm(@RequestParam(name = "teacherId") Long teacherId,
                                               @RequestParam(name = "courseId") Long courseId) {
        Teacher teacher=teacherService.getTeacherById(teacherId);
        Course course=courseService.getCourseById(courseId);
        course.setTeacher(teacher);
        teacher.getCourses().add(course);
        ModelAndView modelAndView = new ModelAndView("redirect:course_list");
        return modelAndView;
    }

}
