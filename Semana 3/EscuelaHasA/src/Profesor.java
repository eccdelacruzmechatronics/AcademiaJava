// Clase Profesor (Independiente) -> Agregación
class Profesor {
    private String nombre;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public void tomarAsistencia() {
        System.out.println("El profesor " + nombre + " toma asistencia.");
    }
}
