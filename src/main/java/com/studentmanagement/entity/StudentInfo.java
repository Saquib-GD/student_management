package com.studentmanagement.entity;

import com.studentmanagement.payload.StudentInfoDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
@Data
public class StudentInfo {

        @Id
        @Column(name = "std_id")
        private Long id;

        @Column(name = "std_name", length = 250)
        private String name;

        @Column(name = "std_address", length = 500)
        private String address;

        @Column(name = "std_email", length = 100)
        private String email;

        @Column(name = "std_phoneno", length = 10)
        private String phoneNo;

        @Column(name = "std_section", length = 3)
        private String section;

        @Column(name = "std_grade", length = 6)
        private String grade;

        public StudentInfoDTO toDTO() {
            StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
            studentInfoDTO.setId(id);
            studentInfoDTO.setName(name);
            studentInfoDTO.setAddress(address);
            studentInfoDTO.setEmail(email);
            studentInfoDTO.setPhoneno(phoneNo);
            studentInfoDTO.setSection(section);
            studentInfoDTO.setGrade(grade);
            return studentInfoDTO;
        }
}