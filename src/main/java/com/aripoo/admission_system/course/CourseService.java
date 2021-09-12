package com.aripoo.admission_system.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getCourses() {
        return courseRepository.findAll();

    }

    public Course getCourseById(Long id) {
        Course course = courseRepository.getById(id);
        return course;
    }

    public void addNewCourse(Course course) {
//        Optional<Course> courseEmail=courseRepository.findCourseByEmail(course.getEmail());
//        if(courseEmail.isPresent()){
//            throw new IllegalStateException("email taken");
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new IllegalStateException("course with id " + courseId + " does not exists");
        }
        courseRepository.deleteById(courseId);
    }

    @Transactional //SDJPA
    public void editCourse(Long courseId, String courseName, String creditNumber) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new IllegalStateException("course with id " + courseId + " does not exist"));

        if (courseName != null && courseName.length() > 0 && !Objects.equals(course.getCourseName(), courseName)) {
            course.setCourseName(courseName);
        }

        if (creditNumber != null && creditNumber.length() > 0 && !Objects.equals(course.getCreditNumber(), creditNumber)) {
            course.setCreditNumber(Integer.parseInt(creditNumber));
        }


    }
}
