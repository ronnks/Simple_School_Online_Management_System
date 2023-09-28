package com.SMM.managementsystem.DATA.classroom;

import com.SMM.managementsystem.MODELS.classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepo  extends JpaRepository<Classroom, String> {
}
