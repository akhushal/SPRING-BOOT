package com.hibernet.intro1.dao;

import com.hibernet.intro1.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


}
