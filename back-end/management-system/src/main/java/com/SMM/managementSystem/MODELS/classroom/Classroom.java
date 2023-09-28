package com.SMM.managementSystem.MODELS.classroom;

import com.SMM.managementSystem.MODELS.student.Student;
import com.SMM.managementSystem.MODELS.assignment.Assignment;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {

    private String className;
    @Id
    private String teacherName;
    @ElementCollection
    private List<Student> studentList;
    @ElementCollection
    private List<Assignment> assignmentList;
}
