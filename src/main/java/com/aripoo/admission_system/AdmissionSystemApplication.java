package com.aripoo.admission_system;

import com.aripoo.admission_system.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication

public class AdmissionSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmissionSystemApplication.class, args);
    }


}
