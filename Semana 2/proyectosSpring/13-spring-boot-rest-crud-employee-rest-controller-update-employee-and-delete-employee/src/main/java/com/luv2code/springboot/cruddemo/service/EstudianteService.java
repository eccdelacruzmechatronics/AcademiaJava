package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Estudiante;

import java.util.List;

public interface EstudianteService {

    List<Estudiante> findAll();

    Estudiante findById(int theId);

    Estudiante save(Estudiante elEstudiante);

    void deleteById(int theId);

}
