

// Clase Aula (Parte de la Escuela) -> Composición
class Aula {
    private String nombre;
    private Profesor profesor;

    public Aula(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public void tomarAsistencia() {
        profesor.tomarAsistencia(); // Delegación: Se delega la tarea al profesor
    }
}
