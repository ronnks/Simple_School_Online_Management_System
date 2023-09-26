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
public class Assignment {
    @Id
    private long id;
    @NotEmpty(message = "assignment name can not be empty")
    private String assignmentName;
    private int possiblePoints;
}
