package com.aripoo.admission_system.result;

import com.aripoo.admission_system.course.Course;
import com.aripoo.admission_system.course.CourseRepository;
import com.aripoo.admission_system.student.Student;
import com.aripoo.admission_system.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Objects;


@Service
public class ResultService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ResultRepository resultRepository;


    @Autowired
    public ResultService(StudentRepository studentRepository, CourseRepository courseRepository, ResultRepository resultRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.resultRepository = resultRepository;

    }


    public List<Result> getResults() {
        return resultRepository.findAll();
//        List<Result> a = null;
//        return a;

    }

    public void addNewResult(Result result) {
        resultRepository.save(result);
    }



    public void deleteResult(Long studentId,Long courseId) {
        Student student=studentRepository.getById(studentId);
        Course course=courseRepository.getById(courseId);
        StudentCourseId resultId=new StudentCourseId(student,course);
        resultRepository.deleteById(resultId);
    }

//    @Transactional
//    public void updateResult(Long studentId, Long courseId, Integer session, Integer mark) {
//        Student student=studentRepository.findById(studentId).orElseThrow(
//                ()->new IllegalStateException("student with id "+ studentId + " does not exist"));
//
//        Course course=courseRepository.findById(courseId).orElseThrow(
//                ()-> new IllegalStateException("course with id "+ courseId + " does not exist"));
//
//        StudentCourseId studentCourseId=new StudentCourseId(student, course);
//
//        Result result= resultRepository.findById(studentCourseId).orElseThrow(
//                ()-> new IllegalStateException("result with student id "+ studentId +" and course id" +
//                        courseId +" does not exist")
//        );
//
//        if(session !=null && session>0 && !Objects.equals(result.getSession(),session)){
//            result.setSession(session);
//        }
//
//        if(mark !=null && mark>0 && !Objects.equals(result.getMark(),mark)){
//            result.setMark(mark);
//        }
//
//    }

}
