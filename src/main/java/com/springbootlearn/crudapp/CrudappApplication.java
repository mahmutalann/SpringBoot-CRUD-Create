package com.springbootlearn.crudapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springbootlearn.crudapp.dao.StudentDAO;
import com.springbootlearn.crudapp.entity.Student;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		
		// create multiple Student
		System.out.println("Creating 3 new Student objects...");
		Student tempStudent1 = new Student("Ahmet", "Mehmet", "ahmet.mehmet@ahmetmehmet.com");
		Student tempStudent2 = new Student("Onur", "Yilmaz", "onur.yilmaz@onuryilmaz.com");
		Student tempStudent3 = new Student("Demir", "Aslan", "demir.aslan@demiaslan.com");
		
		// save multiple Student
		System.out.println("Saving 3 Student objects");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		
		// display id of saved object
		System.out.println("Id of saved object : " + tempStudent1.getId() + ", " + tempStudent2.getId() + ", " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		
		// create student
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("Ali", "Veli", "ali.veli@aliveli.com");
		
		// save Student object
		System.out.println("Saving Student object");
		studentDAO.save(tempStudent);
		
		// display id of saved object
		System.out.println("Id of saved object : " + tempStudent.getId());
	}
	 
}
