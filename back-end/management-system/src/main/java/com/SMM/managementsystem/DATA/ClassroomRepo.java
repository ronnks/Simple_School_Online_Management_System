package com.SMM.managementsystem.DATA;

import com.SMM.managementsystem.MODELS.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepo  extends JpaRepository<List<Student>, Long> {
}
