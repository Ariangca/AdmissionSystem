package com.aripoo.admission_system.result;

import com.aripoo.admission_system.course.Course;
import com.aripoo.admission_system.course.CourseRepository;
import com.aripoo.admission_system.student.Student;
import com.aripoo.admission_system.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
    public Result getResulltById(StudentCourseId id) {
        Result result = resultRepository.getById(id);
        return result;
    }

    @Transactional
    public void updateResult(Long studentId, Long courseId, Integer session, Integer mark) {
        Student student=studentRepository.getById(studentId);
        Course course=courseRepository.getById(courseId);

        Result result=resultRepository.findById(new StudentCourseId(
                student,course
        )).orElseThrow(
                ()->new IllegalStateException("result with student id: "+ student.getId()
                        +" and course id: "+course.getId()+ " does not exist"));

        if(session !=null && session>0 && !Objects.equals(result.getSession(),session)){
            result.setSession(session);
        }

        if(mark !=null && mark>0 && !Objects.equals(result.getMark(),mark)){
            result.setMark(mark);
        }

    }

}
