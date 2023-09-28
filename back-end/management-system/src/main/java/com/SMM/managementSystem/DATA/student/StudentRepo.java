package com.SMM.managementSystem.DATA.student;

import com.SMM.managementSystem.MODELS.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
