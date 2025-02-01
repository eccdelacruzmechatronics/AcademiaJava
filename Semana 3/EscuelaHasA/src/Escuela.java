import java.util.*;
// Clase Escuela (Contiene Aulas) -> Composición
class Escuela {
    private String nombre;
    private List<Aula> aulas;
    private List<Profesor> profesores; // Relación de agregación

    public Escuela(String nombre) {
        this.nombre = nombre;
        this.aulas = new ArrayList<>();
        this.profesores = new ArrayList<>();
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor); // Relación de agregación
    }

    public void agregarAula(String nombreAula, Profesor profesor) {
        Aula aula = new Aula(nombreAula, profesor);
        aulas.add(aula); // Relación de composición
    }

    public void iniciarClases() {
        for (Aula aula : aulas) {
            aula.tomarAsistencia();
        }
    }
}
