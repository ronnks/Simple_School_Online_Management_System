package com.SMM.managementsystem.DATA;

import com.SMM.managementsystem.MODELS.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
