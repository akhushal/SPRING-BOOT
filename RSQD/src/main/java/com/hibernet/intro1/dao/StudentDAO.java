package com.hibernet.intro1.dao;

import com.hibernet.intro1.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student thestudent);
    Student findById(Integer id);
    List<Student> findAll();
    List <Student> findByLastName(String theLastName);
    void delete(Integer id);
    int deleteAll();
}
