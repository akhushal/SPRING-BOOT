package com.hibernet.intro1.dao;

import com.hibernet.intro1.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO {

    //field for entity manager
    private EntityManager entityManager;
    private Student theStudent;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> thelastName = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        thelastName.setParameter("theData", theLastName);
        return thelastName.getResultList();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrive the student
        Student theStudent = entityManager.find(Student.class, id);
        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numsRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numsRowsDeleted;
    }


}
