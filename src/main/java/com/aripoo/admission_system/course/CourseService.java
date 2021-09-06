package com.aripoo.admission_system.course;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getCourse(){
        return courseRepository.findAll();

    }

    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Transactional
    public void updateCourse(Long courseId, String courseName, Integer creditNumber) {
        Course course= courseRepository.findById(courseId).orElseThrow(
                ()->new IllegalStateException("course with id "+ courseId + " does not exist"));

        if(courseName != null && courseName.length()>0 &&
                !Objects.equals(courseName,course.getCourseName())){
            course.setCourseName(courseName);
        }

        if(creditNumber != null && creditNumber>0 &&
                !Objects.equals(creditNumber,course.getCreditNumber())){
            course.setCreditNumber(creditNumber);
        }

    }
}
