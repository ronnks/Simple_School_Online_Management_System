package com.SMM.managementSystem.MODELS.assignmentGrade;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentGrade {
    @Id
    private long id;
    @NotEmpty(message = "grade score can not be empty")
    private int score;
}
