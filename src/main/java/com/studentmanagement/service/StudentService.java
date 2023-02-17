package com.studentmanagement.service;

import com.studentmanagement.payload.StudentDetailsResponse;
import com.studentmanagement.payload.StudentInfoDTO;
import com.studentmanagement.payload.StudentMarksDTO;

import java.util.List;

public interface StudentService {

    int createStudentDetails(List<StudentInfoDTO> studentInfoDTO);
    List<StudentInfoDTO> getStudentDetails();
    boolean isStudentDetailsPresent(Long id);
    void createStudentMarks(StudentMarksDTO studentMarksDTO);
    StudentDetailsResponse getStudentDetails(Long id);
}
