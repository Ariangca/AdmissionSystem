package com.aripoo.admission_system.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Controller
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(path = "/course_list")
    public String getCourses(Model model) {

        model.addAttribute("course_list", courseService.getCourses());
        return "course/course_list";
    }

    @GetMapping(path = "/course_add")
    public String course_form(Model model) {
        Course course = new Course();
        model.addAttribute("courseData", course);
        return "course/course_add";
    }

    //,headers = {"content-type=text/json"}
    @PostMapping(path = "/course_add")
    public ModelAndView registerNewCourse(@ModelAttribute Course course, Model model) {
        courseService.addNewCourse(course);
        ModelAndView modelAndView = new ModelAndView("redirect:/course_list");
        return modelAndView;
    }

    @GetMapping(path = "/course_delete")
    public ModelAndView deleteCourse(@RequestParam(name = "courseId") String courseId) {
        courseService.deleteCourse(Long.parseLong(courseId));
        ModelAndView modelAndView = new ModelAndView("redirect:/course_list");
        return modelAndView;
    }

    @GetMapping(path = "/course_edit/{course_id}")
    public String editCourse(@PathVariable(name = "course_id") String courseId, Model model) {
        model.addAttribute("courseId", courseId);
        return "/course/course_edit";
    }


    @PostMapping(path = "/course_edit/{courseId}")
    public ModelAndView updateCourse(
            @PathVariable("courseId") Long courseId,
            @RequestParam(required = false) String courseName,
            @RequestParam(required = false) String creditNumber) {
        courseService.editCourse(courseId, courseName, creditNumber);
        return new ModelAndView("redirect:/course_list");
    }
    @GetMapping(path = "/course_info/{courseId}")
    public String courseInfo(@PathVariable Long courseId,Model model){
        Course course=courseService.getCourseById(courseId);
        model.addAttribute("course",course);
        return "course/course_info";
    }
}
