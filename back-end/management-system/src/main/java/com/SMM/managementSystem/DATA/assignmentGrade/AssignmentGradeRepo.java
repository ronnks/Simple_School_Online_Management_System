package com.SMM.managementSystem.DATA.assignmentGrade;

import com.SMM.managementSystem.MODELS.assignmentGrade.AssignmentGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentGradeRepo  extends JpaRepository<AssignmentGrade, String> {
}
