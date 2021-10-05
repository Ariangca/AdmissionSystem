package com.aripoo.admission_system.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
@Table
public class Result {

    //    private String student;
//    private String course;
    @EmbeddedId
    private StudentCourseId id;

    private Integer session;

    private Integer mark;

    public Result() {
    }

    public Result(StudentCourseId id, Integer session, Integer mark) {
        this.id = id;
        this.session = session;
        this.mark = mark;
    }
}
