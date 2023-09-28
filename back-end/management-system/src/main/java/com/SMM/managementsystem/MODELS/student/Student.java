package com.SMM.managementsystem.MODELS.student;

import com.SMM.managementsystem.MODELS.assignmentGrade.AssignmentGrade;
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
    private String studentName;
    private List<AssignmentGrade> assignmentGrade;

    // Sums up the scores for a student.
    public int getGrade(){
        Optional<Integer> sum = this.assignmentGrade.stream().map(grade -> grade.getScore()).reduce((a, b) -> a + b);
        return sum.get();
    }
}
