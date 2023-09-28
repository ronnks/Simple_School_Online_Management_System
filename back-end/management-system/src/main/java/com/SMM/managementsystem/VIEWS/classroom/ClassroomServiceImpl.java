package com.SMM.managementsystem.VIEWS.classroom;

import com.SMM.managementsystem.DATA.classroom.ClassroomRepo;
import com.SMM.managementsystem.MODELS.classroom.Classroom;
import com.SMM.managementsystem.MODELS.student.Student;
import com.SMM.managementsystem.MODELS.teacher.Teacher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepo classroomRepo;
    @Override
    public Classroom create(Classroom classroom) {
        log.info("saving new classroom in DB: {}", classroom.getTeacherName());
        return classroomRepo.save(classroom);
    }

    // Getting classroom by teacher name.
    public Optional<Classroom> getClassroom(Teacher teacher) {
        log.info("saving new classroom in DB: {}", teacher.getName());
        return classroomRepo.findById(teacher.getName());
    }

    @Override
    public Collection<Classroom> list(int limit) {
        log.info("getting all classrooms");
        return classroomRepo.findAll();
    }

    // Find student in a classroom by their id.
    @Override
    public Student get(Teacher teacher, Long id) {
        log.info("finding student by Id: {}", id);
        return (Student) this.getClassroom(teacher)
                .stream()
                .map(classroom -> classroom.getStudentList()
                .stream()
                .allMatch(student -> student.getId() == id));
    }

    // Finding student by assignment id.
    @Override
    public Student getAssignmentById(Teacher teacher, String assignmentName) {
        log.info("finding student by assignment name: {}", assignmentName);

        return (Student) this.getClassroom(teacher)
                .stream()
                .map(classroom -> classroom.getAssignmentList()
                .stream()
                .allMatch(assignment -> assignment.getAssignmentName() == assignmentName));
    }

    @Override
    public Classroom update(Classroom classroom) {
        log.info("update an entire classroom: {}", classroom.getTeacherName());
        return classroomRepo.save(classroom);
    }

    @Override
    public Boolean delete(Classroom classroom) {
        log.info("deleting a classroom: {}", classroom.getTeacherName());
        classroomRepo.delete(classroom);
        return Boolean.TRUE;
    }
}
