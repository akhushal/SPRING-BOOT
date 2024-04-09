package com.hibernet.intro1;

import com.hibernet.intro1.entity.Student;
import com.hibernet.intro1.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Intro1Application {

	public static void main(String[] args) {
		SpringApplication.run(Intro1Application.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudetns(studentDAO);
		};
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
}
