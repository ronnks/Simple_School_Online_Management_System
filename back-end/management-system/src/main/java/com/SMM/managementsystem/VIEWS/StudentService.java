package com.SMM.managementsystem.VIEWS;

import com.SMM.managementsystem.MODELS.Assignment;
import com.SMM.managementsystem.MODELS.Student;

import java.util.Collection;

public interface StudentService {
    Student create(Student student);
    Collection<Student> list(int limit);
    Student get(Long id);
    Student getAssignmentById(Assignment assignment);
    Student getGrade(Student student);
    Student update(Student student);
    Boolean delete(Long id);
}
