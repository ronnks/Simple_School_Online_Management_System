package com.SMM.managementsystem.VIEWS.Implementation;

import com.SMM.managementsystem.DATA.StudentRepo;
import com.SMM.managementsystem.MODELS.Assignment;
import com.SMM.managementsystem.MODELS.Student;
import com.SMM.managementsystem.VIEWS.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService{
    private final StudentRepo studentRepo;

    @Override
    public Student create(Student student) {
        log.info("saving new student in DB: {}", student.getStudentName());
        return studentRepo.save(student);
    }

    @Override
    public Collection<Student> list(int limit) {
        log.info("getting all students");
        return studentRepo.findAll().stream().limit(limit).toList();
    }

    @Override
    public Student get(Long id) {
        log.info("getting a student by id: {}", id);
        return studentRepo.findById(id).get();
    }

    @Override
    public Student getAssignmentById(Assignment assignment) {
        log.info("getting a student by assignment name: {}", assignment.getId());
        return studentRepo.findById(assignment.getId()).get();
    }

    @Override
    public Student getGrade(Student student) {
        log.info("getting a student's grade: {}", student.getGrade());
        return studentRepo.findById(student.getId()).get();
    }

    @Override
    public Student update(Student student) {
        log.info("updating student in DB: {}", student.getStudentName());
        return studentRepo.save(student);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting a student from the DB: {}", id);
        studentRepo.deleteById(id);
        return Boolean.TRUE;
    }
}
