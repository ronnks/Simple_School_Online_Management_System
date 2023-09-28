package com.SMM.managementsystem;

import com.SMM.managementsystem.DATA.student.StudentRepo;
import com.SMM.managementsystem.MODELS.assignmentGrade.AssignmentGrade;
import com.SMM.managementsystem.MODELS.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner run(StudentRepo studentRepo){
		return args -> {
			studentRepo.save(new Student(1, "Ronald Kato", List.of(new AssignmentGrade(1108, 12),
							                                                       new AssignmentGrade(0234, 23))));
			studentRepo.save(new Student(11, "Ronald Kato", List.of(new AssignmentGrade(1109, 55),
					                                                               new AssignmentGrade(8029, 38))));
			studentRepo.save(new Student(9, "Ronald Kato", List.of(new AssignmentGrade(1110, 26),
					                                                               new AssignmentGrade(2336, 14))));
			studentRepo.save(new Student(5, "Ronald Kato", List.of(new AssignmentGrade(1111, 35),
				                                                  	               new AssignmentGrade(3822, 9))));
		};
	}
	/*spring.jpa.show-sql=true
	spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
	spring.jpa.generate-ddl=true
	spring.jpa.hibernate.ddl-auto = update*/
}
