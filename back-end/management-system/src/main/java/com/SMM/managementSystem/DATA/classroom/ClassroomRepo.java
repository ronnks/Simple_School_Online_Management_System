package com.SMM.managementSystem.DATA.classroom;

import com.SMM.managementSystem.MODELS.classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepo  extends JpaRepository<Classroom, String> {
}
