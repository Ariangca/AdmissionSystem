package com.aripoo.admission_system.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository){
//        return args -> {
//            Student s1=new Student(
//                    1L,
//                    "ghazanfar",
//                    "ghazi@gmail.com",
//                    LocalDate.of(1980, Month.AUGUST, 5)
//            );
//            Student s2=new Student(
//                    "test2",
//                    "test2@gmail.com",
//                    LocalDate.of(1997, Month.AUGUST, 5)
//            );
//            repository.saveAll(
//                    List.of(s1,s2)
//            );
//        };
//
//    }
}
