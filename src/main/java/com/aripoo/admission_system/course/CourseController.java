package com.aripoo.admission_system.course;

import com.aripoo.admission_system.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(path = "/course_list")
    public List<Course> getCourse(){
        return courseService.getCourse();
    }

    @PostMapping(path = "/course_add")
    public void addNewCourse(@RequestBody Course course){
        courseService.addNewCourse(course);
    }

    @DeleteMapping(path = "/edit_course/{courseId}")
    public void deleteCourse(@PathVariable("courseID") Long courseId){
        courseService.deleteCourse(courseId);
    }

    @PutMapping(path = "/edit_course/{courseId}")
    public void updatecourse(@PathVariable("courseId") Long courseId,
                             @RequestParam(required = false) String courseName,
                             @RequestParam(required = false) Integer creditNumber){
        courseService.updateCourse(courseId,courseName,creditNumber);
    }
}
