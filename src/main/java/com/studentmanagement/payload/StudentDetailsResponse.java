package com.studentmanagement.payload;

import com.studentmanagement.entity.StudentInfo;
import com.studentmanagement.entity.StudentMarks;
import lombok.Data;

@Data
public class StudentDetailsResponse {

    private StudentInfo studentInfo;
    private StudentMarks studentMarks;

    public StudentDetailsResponse(StudentInfo studentInfo, StudentMarks studentMarks) {
        this.studentInfo = studentInfo;
        this.studentMarks = studentMarks;
    }
}
