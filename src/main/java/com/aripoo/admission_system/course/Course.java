package com.aripoo.admission_system.course;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
