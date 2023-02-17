package com.studentmanagement.controller;

import com.studentmanagement.payload.MessageResponse;
import com.studentmanagement.payload.StudentDetailsResponse;
import com.studentmanagement.payload.StudentInfoDTO;
import com.studentmanagement.payload.StudentMarksDTO;
import com.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/details")
    public ResponseEntity<MessageResponse> createStudentDetails(@RequestBody List<StudentInfoDTO> studentInfoDTO) {
        int count = studentService.createStudentDetails(studentInfoDTO);
        MessageResponse messageResponse = new MessageResponse("" + count + " records inserted successful", "00");
        return ResponseEntity.ok(messageResponse);
    }

    @GetMapping("/details")
    public ResponseEntity<List<StudentInfoDTO>> getStudentDetails() {
        List<StudentInfoDTO> studentDetails = studentService.getStudentDetails();
        return new ResponseEntity<>(studentDetails, HttpStatus.ACCEPTED);
    }

    @PostMapping("/marks/detail")
    public ResponseEntity<MessageResponse> createStudentMarks(@RequestBody StudentMarksDTO studentMarksDTO) {
        if(studentService.isStudentDetailsPresent(studentMarksDTO.getId())) {
            studentService.createStudentMarks(studentMarksDTO);
            MessageResponse successMessageResponse = new MessageResponse("record inserted successfully", "00");
            return ResponseEntity.ok(successMessageResponse);
        }else {
            MessageResponse failMessageResponse = new MessageResponse("record insertion failed!", "99");
            return ResponseEntity.badRequest().body(failMessageResponse);
        }
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Object> getStudentAndMarksDetails(@PathVariable Long id) {
        StudentDetailsResponse studentDetailsResponse = studentService.getStudentDetails(id);
        if (studentDetailsResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentDetailsResponse,HttpStatus.ACCEPTED);
    }
}
