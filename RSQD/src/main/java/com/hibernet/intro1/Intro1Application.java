package com.hibernet.intro1;

import com.hibernet.intro1.entity.Student;
import com.hibernet.intro1.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Intro1Application {

	public static void main(String[] args) {
		SpringApplication.run(Intro1Application.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
//			createMultipleStudetns(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			searchStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllData(studentDAO);
		};
	}

	private void deleteAllData(StudentDAO studentDAO) {
		System.out.println("deleting all dat");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("deleted row count: "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("deleting id "+studentId);
		studentDAO.delete(studentId);
		queryForStudents(studentDAO);
	}


	private void searchStudent(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudent = studentDAO.findByLastName("panda");
		for (Student tempStudent: theStudent){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display the list of students
		for (Student tempStudent: theStudents){
			System.out.println("students : " + tempStudent);
		}
	}

	private void createMultipleStudetns(StudentDAO studentDAO) {
		System.out.println("creating 3 objects");
		Student tempStudent1 = new Student("khushal", "Aravapalli", "khushal@gmail.com");
		Student tempStudent2 = new Student("shalu", "panda", "pandashalu@gmail.com");
		Student tempStudent3 = new Student("titu", "mohit", "titu@gmail.com");
		System.out.println("saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("creating an object");
		Student tempStudent = new Student("khushal", "Aravapalli", "khushal@gmail.com");
		// save the student object
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("saved the student "+ tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO){
		// create a student object
		System.out.println("creating an object");
		Student tempStudent = new Student("khushal", "Aravapalli", "khushal@gmail.com");
		// save the student
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("student it: " + theId);
		// retrieve student based on id
		System.out.println("retrieving the student id: "+ theId);
		Student mystudent = studentDAO.findById(theId);
		// display student
		System.out.println("found the student: "+ mystudent);
	}
}
