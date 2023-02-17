package com.studentmanagement.payload;

import com.studentmanagement.entity.StudentInfo;
import lombok.Data;

@Data
public class StudentInfoDTO {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phoneno;
    private String section;
    private String grade;

    public StudentInfo toEntity() {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(id);
        studentInfo.setName(name);
        studentInfo.setAddress(address);
        studentInfo.setEmail(email);
        studentInfo.setPhoneNo(phoneno);
        studentInfo.setSection(section);
        studentInfo.setGrade(grade);
        return studentInfo;
    }
}
