package com.studentmanagement.service.impl;

import com.studentmanagement.entity.StudentInfo;
import com.studentmanagement.entity.StudentMarks;
import com.studentmanagement.payload.StudentDetailsResponse;
import com.studentmanagement.payload.StudentInfoDTO;
import com.studentmanagement.payload.StudentMarksDTO;
import com.studentmanagement.repository.StudentInfoRepository;
import com.studentmanagement.repository.StudentMarksRepository;
import com.studentmanagement.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Autowired
    private StudentMarksRepository studentMarksRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public int createStudentDetails(List<StudentInfoDTO> studentInfoDTO) {
        List<StudentInfo> studentInfos = studentInfoDTO.stream().map(StudentInfoDTO::toEntity).collect(Collectors.toList());
        studentInfoRepository.saveAll(studentInfos);
        return studentInfos.size();
    }

    @Override
    public List<StudentInfoDTO> getStudentDetails() {
        List<StudentInfo> allDetails = studentInfoRepository.findAll();
        List<StudentInfoDTO> allStudentDetails = allDetails.stream().map(StudentInfo::toDTO).collect(Collectors.toList());
        return allStudentDetails;
    }

    @Override
    public boolean isStudentDetailsPresent(Long id) {
        return studentInfoRepository.existsById(id);
    }

    @Override
    public void createStudentMarks(StudentMarksDTO studentMarksDTO) {
        StudentMarks studentMarks = new StudentMarks();
        studentMarks.setId(studentMarksDTO.getId());
        studentMarks.setSemester(studentMarksDTO.getSemester());
        studentMarks.setSession(studentMarksDTO.getSession());
        studentMarks.setTotalSubject(studentMarksDTO.getTotalSubject());
        studentMarks.setTotalMarks(studentMarksDTO.getTotalMarks());
        studentMarksRepository.save(studentMarks);
    }

    @Override
    public StudentDetailsResponse getStudentDetails(Long id) {
        StudentInfo studentInfo = studentInfoRepository.findById(id).orElse(null);
        if (studentInfo==null) {
            return null;
        }
        StudentMarks studentMarks = studentMarksRepository.findById(id).orElse(null);
        return new StudentDetailsResponse(studentInfo, studentMarks);
    }

    private StudentInfoDTO mapToDto(List<StudentInfo> studentInfo) {
        StudentInfoDTO studentInfoDTO = mapper.map(studentInfo, StudentInfoDTO.class);
//        StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
//        studentInfoDTO.setId(studentInfo.getId());
//        studentInfoDTO.setName(studentInfo.getName());
//        studentInfoDTO.setAddress(studentInfo.getAddress());
//        studentInfoDTO.setEmail(studentInfo.getEmail());
//        studentInfoDTO.setPhoneno(studentInfo.getPhoneNo());
//        studentInfoDTO.setSection(studentInfo.getSection());
//        studentInfoDTO.setGrade(studentInfo.getGrade());
        return studentInfoDTO;
    }

    private StudentInfo mapToEntity(List<StudentInfoDTO> studentInfoDTO) {
        StudentInfo studentInfo = mapper.map(studentInfoDTO, StudentInfo.class);
//        StudentInfo studentInfo = new StudentInfo();
//        studentInfo.setId(studentInfoDTO.getId());
//        studentInfo.setName(studentInfoDTO.getName());
//        studentInfo.setAddress(studentInfoDTO.getAddress());
//        studentInfo.setEmail(studentInfoDTO.getEmail());
//        studentInfo.setPhoneNo(studentInfoDTO.getPhoneno());
//        studentInfo.setSection(studentInfoDTO.getSection());
//        studentInfo.setGrade(studentInfoDTO.getGrade());
        return studentInfo;
    }
}