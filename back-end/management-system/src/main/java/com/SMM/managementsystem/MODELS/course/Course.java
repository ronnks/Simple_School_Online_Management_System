package com.SMM.managementsystem.MODELS.course;

import com.SMM.managementsystem.MODELS.assignment.Assignment;
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
public class Course {
    @Id
    private long id;
    private List<Assignment> assignmentList;
}