package com.kd.JDBCproject;

import com.kd.JDBCproject.model.Student;
import com.kd.JDBCproject.repo.StudentRepo;
import jakarta.servlet.ServletOutputStream;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbCprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbCprojectApplication.class, args);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		StudentRepo repo =context.getBean(StudentRepo.class);

//		s1.setRollNo(101);
//		s1.setName("Navin");
//		s1.setMarks(75);
//
		s2.setRollNo(102);
		s2.setName("Kiran");
		s2.setMarks(80);
//
		s3.setRollNo(103);
		s3.setName("Harshi");
		s3.setMarks(85);
//
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);

		System.out.println(repo.findById(102));
		System.out.println(repo.findByName("Navin"));
		System.out.println(repo.findByMarks(89));

		repo.save(s3);
		repo.delete(s2);
	}

}
