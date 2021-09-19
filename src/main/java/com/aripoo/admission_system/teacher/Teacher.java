package com.aripoo.admission_system.teacher;

import com.aripoo.admission_system.course.Course;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
@Table
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private Long salary;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;


    public Teacher() {
    }

    public Teacher(String firstName, String lastName,
                   String address, String city, String country,
                   String phoneNumber, Long salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public Teacher(Long id) {
        this.id = id;
    }
}
