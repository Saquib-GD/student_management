package com.studentmanagement.payload;

import lombok.Data;

@Data
public class StudentMarksDTO {
    private Long id;
    private String session;
    private String semester;
    private Integer totalSubject;
    private Integer totalMarks;
}
