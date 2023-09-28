package com.SMM.managementSystem.MODELS.student;

import com.SMM.managementSystem.MODELS.assignmentGrade.AssignmentGrade;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    @NotEmpty(message = "Student name can not be empty")
    private String firstName;
    @NotEmpty(message = "Student name can not be empty")
    private String lastName;
    @ElementCollection
    private List<AssignmentGrade> assignmentGrade;

    // Sums up the scores for a student.
    public int getGrade(){
        Optional<Integer> sum = this.assignmentGrade.stream().map(grade -> grade.getScore()).reduce((a, b) -> a + b);
        return sum.get();
    }

    public String getStudentName(){
        return this.firstName+" "+ lastName;
    }
}
