package com.aripoo.admission_system.result;


import com.aripoo.admission_system.course.Course;
import com.aripoo.admission_system.student.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Getter
@Setter
@ToString


@Embeddable
public class StudentCourseId implements Serializable {

    @OneToOne
    protected Student student;

    @OneToOne
    protected Course course;

    public StudentCourseId() {
    }

    public StudentCourseId(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
