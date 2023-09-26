package com.SMM.managementsystem.MODELS;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
