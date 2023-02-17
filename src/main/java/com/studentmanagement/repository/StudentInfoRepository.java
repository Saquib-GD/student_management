package com.studentmanagement.repository;

import com.studentmanagement.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {

}
