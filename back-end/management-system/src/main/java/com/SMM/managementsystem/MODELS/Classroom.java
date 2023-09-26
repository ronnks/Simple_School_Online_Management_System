package com.SMM.managementsystem.MODELS;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
