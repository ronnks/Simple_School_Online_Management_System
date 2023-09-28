package com.SMM.managementSystem.DATA.assignment;

import com.SMM.managementSystem.MODELS.assignment.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepo  extends JpaRepository<Assignment, String> {
}
