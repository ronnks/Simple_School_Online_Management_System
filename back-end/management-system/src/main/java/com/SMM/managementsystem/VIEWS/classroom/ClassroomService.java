package com.SMM.managementsystem.VIEWS.classroom;

import com.SMM.managementsystem.MODELS.classroom.Classroom;
import com.SMM.managementsystem.MODELS.student.Student;
import com.SMM.managementsystem.MODELS.teacher.Teacher;

import java.util.Collection;
import java.util.Optional;

public interface ClassroomService {
    Classroom create(Classroom classroom);
    Optional<Classroom> getClassroom(Teacher teacher);
    Collection<Classroom> list(int limit);
    // Find student in a classroom by their id.
    Student get(Teacher teacher, Long id);
    Student getAssignmentById(Teacher teacher, String assignmentName);
    Classroom update(Classroom classroom);
    Boolean delete(Classroom classroom);
}
