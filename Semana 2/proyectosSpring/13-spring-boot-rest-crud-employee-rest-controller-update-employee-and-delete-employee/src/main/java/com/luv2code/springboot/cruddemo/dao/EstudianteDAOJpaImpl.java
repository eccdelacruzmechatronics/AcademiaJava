package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Estudiante; //changed
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstudianteDAOJpaImpl implements EstudianteDAO {

    // define field for entitymanager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public EstudianteDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Estudiante> findAll() {

        // create a query
        TypedQuery<Estudiante> theQuery = entityManager.createQuery("from Estudiante", Estudiante.class); //estudiantes

        // execute query and get result list
        List<Estudiante> estudiantes = theQuery.getResultList();

        // return the results
        return estudiantes;
    }

    @Override
    public Estudiante findById(int theId) {

        // get employee
        Estudiante elEstudiante = entityManager.find(Estudiante.class, theId);

        // return employee
        return elEstudiante;
    }

    @Override
    public Estudiante save(Estudiante elEstudiante) {

        // save employee
        Estudiante dbEstudiante = entityManager.merge(elEstudiante);

        // return the dbEmployee
        return dbEstudiante;
    }

    @Override
    public void deleteById(int theId) {

        // find employee by id
        Estudiante elEstudiante = entityManager.find(Estudiante.class, theId);

        // remove employee
        entityManager.remove(elEstudiante);
    }
}











