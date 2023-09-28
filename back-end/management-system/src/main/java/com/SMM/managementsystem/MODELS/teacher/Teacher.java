package com.SMM.managementsystem.MODELS.teacher;

import com.SMM.managementsystem.MODELS.course.Course;
import com.SMM.managementsystem.MODELS.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    private long id;
    private String name;
    private List<Course> courseList;
    private List<Student> studentList;

}
