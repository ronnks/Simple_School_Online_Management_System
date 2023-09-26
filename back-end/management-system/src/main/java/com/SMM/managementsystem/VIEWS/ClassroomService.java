package com.SMM.managementsystem.VIEWS;

import com.SMM.managementsystem.MODELS.Assignment;
import com.SMM.managementsystem.MODELS.Course;
import com.SMM.managementsystem.MODELS.Student;

import java.util.Collection;

public interface ClassroomService {
    Student create(Student student);
    Collection<Student> list(int limit);
    Student get(Long id);
    Student getAssignmentById(String assignmentName);
    Student getAvgClassGrade();
    Student getCourseAvgGrade();
    Student update(Student student);
    Student update(Course course);
    Student update(Assignment assignment);
    Boolean delete(Long id);
}
