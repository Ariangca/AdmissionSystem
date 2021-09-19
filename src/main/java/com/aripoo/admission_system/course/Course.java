package com.aripoo.admission_system.course;

import com.aripoo.admission_system.student.Student;
import com.aripoo.admission_system.teacher.Teacher;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long id;
    private String courseName;
    private Integer creditNumber;

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    @ManyToOne
    private Teacher teacher ;


    public Course() {
    }

    public Course(String courseName, Integer creditNumber) {
        this.courseName = courseName;
        this.creditNumber = creditNumber;
    }

    public Course(Long id) {
        this.id = id;
    }
}
