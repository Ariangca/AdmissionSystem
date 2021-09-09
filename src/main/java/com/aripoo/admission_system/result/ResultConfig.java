package com.aripoo.admission_system.result;

import com.aripoo.admission_system.course.Course;
import com.aripoo.admission_system.course.CourseRepository;
import com.aripoo.admission_system.student.Student;
import com.aripoo.admission_system.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class ResultConfig {
    @Bean
    CommandLineRunner commandLineRunner(ResultRepository repository, StudentRepository studentRepository, CourseRepository courseRepository) {
        return args -> {
            Student s1=new Student("asghar","gholi","gmail", LocalDate.now());
            Course c1=new Course("c1",2);
            Result r1 = new Result(new StudentCourseId(s1,c1),2,2);
            studentRepository.save(s1);
            courseRepository.save(c1);
            repository.saveAll(List.of(r1));
        };
    }
}