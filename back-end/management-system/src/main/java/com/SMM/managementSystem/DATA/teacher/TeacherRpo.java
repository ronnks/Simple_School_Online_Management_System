package com.SMM.managementSystem.DATA.teacher;

import com.SMM.managementSystem.MODELS.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRpo  extends JpaRepository<Teacher, String> {
}
