package com.studentmanagement.repository;

import com.studentmanagement.entity.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentMarksRepository extends JpaRepository<StudentMarks, Long> {

}
