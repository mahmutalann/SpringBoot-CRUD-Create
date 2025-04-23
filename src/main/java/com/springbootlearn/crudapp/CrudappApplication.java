package com.springbootlearn.crudapp;

import java.util.List;

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
			
			//readStudent(studentDAO);
			
			//queryForStudents(studentDAO);
			
			//querForStudentsByLastName(studentDAO);
			
			//updateStudent(studentDAO);
			
			// deleteStudent(studentDAO);
			
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All Students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
		}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 6;
		System.out.println("Deleting student id : " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
	
		// retrieve student based on the id : primary key
		int studentId = 6;
		System.out.println("Getting student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		// change first name to "xyz"
		System.out.println("Updating student...");
		myStudent.setFirstName("Software");
		
		// update the student
		studentDAO.update(myStudent);
		
		// display the updated student
		System.out.println("Updated student :  " + myStudent);
		
	}

	private void querForStudentsByLastName(StudentDAO studentDAO) {
		
		// get a list of students	
		List<Student> theStudents = studentDAO.findByLastName("Hardware");
	
		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	
	}

	private void queryForStudents(StudentDAO studentDAO) {
		
		// get a list of students
		List<Student> theStudents =studentDAO.findAll();
		
		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		
		// create student
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("Software", "Hardware", "software.hardware@softwarehardware.com");
		
		// save Student object
		System.out.println("Saving Student object");
		studentDAO.save(tempStudent);
		
		//  display id of saved object
		int theId = tempStudent.getId();
		System.out.println("Id of saved object : " + theId);
		
		// retrieve student based on the id : primary key
		System.out.println("Retrieving student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);
		
		// display student
		System.out.println("Found the Student : " + myStudent);
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
