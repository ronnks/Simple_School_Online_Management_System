package com.SMM.managementsystem.MODELS.classroom;

import com.SMM.managementsystem.MODELS.student.Student;
import com.SMM.managementsystem.MODELS.assignment.Assignment;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
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

    @Id
    private String teacherName;
    @NotEmpty(message = "Course name can not be empty")
    private String courseName;
    private List<Student> studentList;
    private List<Assignment> assignmentList;
}
