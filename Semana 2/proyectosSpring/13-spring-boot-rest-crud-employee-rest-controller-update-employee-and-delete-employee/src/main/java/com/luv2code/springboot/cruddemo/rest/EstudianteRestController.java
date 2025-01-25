package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Estudiante;
import com.luv2code.springboot.cruddemo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudianteRestController {

    private EstudianteService EstudianteService;

    @Autowired
    public EstudianteRestController(EstudianteService elEstudianteService) {
        EstudianteService = elEstudianteService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/estudiantes")
    public List<Estudiante> findAll() {
        return EstudianteService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/estudiantes/{estudianteId}")
    public Estudiante getEstudiante(@PathVariable int estudianteId) {

        Estudiante elEstudiante = EstudianteService.findById(estudianteId);

        if (elEstudiante == null) {
            throw new RuntimeException("Estudiante id not found - " + estudianteId);
        }

        return elEstudiante;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/estudiantes")
    public Estudiante addEstudiante(@RequestBody Estudiante elEstudiante) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        elEstudiante.setId(0);

        Estudiante dbEstudiante = EstudianteService.save(elEstudiante);

        return dbEstudiante;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/estudiantes")
    public Estudiante updateEstudiante(@RequestBody Estudiante elEstudiante) {

        Estudiante dbEstudiante = EstudianteService.save(elEstudiante);

        return dbEstudiante;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/estudiantes/{estudianteId}")
    public String deleteEstudiante(@PathVariable int estudianteId) {

        Estudiante tempEstudiante = EstudianteService.findById(estudianteId);

        // throw exception if null

        if (tempEstudiante == null) {
            throw new RuntimeException("Estudiante id not found - " + estudianteId);
        }

        EstudianteService.deleteById(estudianteId);

        return "Deleted estudiante id - " + estudianteId;
    }

}














