package com.aripoo.admission_system.result;

import com.aripoo.admission_system.course.Course;
import com.aripoo.admission_system.student.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping(path = "/result_list")
    public List<Result> getResults(){
        return resultService.getResults();
    }

    @PostMapping(path = "/result_add")
    public void addNewResult(@RequestBody Result result){
        resultService.addNewResult(result);
    }

    @DeleteMapping(path = "/edit_result/{studentId}/{courseId}")
    public void deleteResult(@PathVariable Long studentId,@PathVariable Long courseId){
        resultService.deleteResult(new StudentCourseId(new Student(studentId),new Course(courseId)));
    }

    @PutMapping(path = "/edit_result/{studentId}/{courseId}")
    public void updateResult(@PathVariable("studentId") Long studentId,
                             @PathVariable("courseId") Long courseId,
                             @RequestParam(required = false) Integer session,
                             @RequestParam(required = false) Integer mark){
        resultService.updateResult(studentId, courseId, session, mark);
    }
}
