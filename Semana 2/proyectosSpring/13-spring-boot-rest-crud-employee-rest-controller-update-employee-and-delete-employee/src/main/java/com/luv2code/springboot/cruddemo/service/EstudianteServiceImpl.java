package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EstudianteDAO;
import com.luv2code.springboot.cruddemo.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private EstudianteDAO EstudianteDAO;

    @Autowired
    public EstudianteServiceImpl(EstudianteDAO elEstudianteDAO) {
        EstudianteDAO = elEstudianteDAO;
    }

    @Override
    public List<Estudiante> findAll() {
        return EstudianteDAO.findAll();
    }

    @Override
    public Estudiante findById(int theId) {
        return EstudianteDAO.findById(theId);
    }

    @Transactional
    @Override
    public Estudiante save(Estudiante elEstudiante) {
        return EstudianteDAO.save(elEstudiante);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        EstudianteDAO.deleteById(theId);
    }
}






