package com.aripoo.admission_system.student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@ToString

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "studnet_sequence",
            sequenceName = "studnet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studnet_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private String major;


    public Student() {
    }

    public Student(String firstName, String lastName,
                   String address, String city, String country,
                   String phoneNumber, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.major = major;
    }

    public Student(Long id) {
        this.id = id;
    }
}
