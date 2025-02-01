package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EstudianteRepository;
import com.luv2code.springboot.cruddemo.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final  EstudianteRepository estudianteRepository; //se añadio final

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository; //se añadio this
    }

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante findById(int theId) {
        Optional<Estudiante> result = estudianteRepository.findById(theId);

        Estudiante estudiante = null;

        if (result.isPresent()) {
            estudiante = result.get();
        }
        else {
            // no se encontro al estudiante
            throw new RuntimeException("No se encontró el id - " + theId);
        }

        return estudiante;
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void deleteById(int theId) {
        estudianteRepository.deleteById(theId);
    }
}






