package com.studentmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student_marks")
@Data
public class StudentMarks {

    @Id
    @Column(name = "std_id")
    private Long id;

    @Column(name = "session", length = 9)
    private String session;

    @Column(name = "semester", length = 30)
    private String semester;

    @Column(name = "total_subject")
    private Integer totalSubject;

    @Column(name = "total_marks")
    private Integer totalMarks;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "std_id")
    private StudentInfo studentInfo;

}