package com.SMM.managementsystem.DATA.student;

import com.SMM.managementsystem.MODELS.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
