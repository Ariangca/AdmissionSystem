package com.aripoo.admission_system.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString

@Entity
@Table
public class Result implements Serializable {


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
