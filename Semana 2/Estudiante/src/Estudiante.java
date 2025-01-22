

import java.util.ArrayList;
import java.util.Scanner;
// Clase Estudiante
class Estudiante {
    private String id; // ID o boleta del estudiante (private, no accesible directamente desde otras clases)
    protected String nombre; // Nombre del alumno (protected, accesible desde clases derivadas)
    private ArrayList<Double> calificaciones;

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
    }

    // Método para agregar una calificación al estudiante
    public void agregarCalificacion(double calificacion) {
        this.calificaciones.add(calificacion);
    }

    // Métodos getters y setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    // Sobreescribir el método toString para mostrar la información del alumno
    @Override
    public String toString() {
        return "ID: " + id + ", Estudiante: " + nombre + ", Calificaciones: " + calificaciones;
    }
}
