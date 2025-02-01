public class Main {
    public static void main(String[] args) {
        Escuela escuela = new Escuela("Instituto Nacional");
        
        Profesor prof1 = new Profesor("Luis Pérez");
        Profesor prof2 = new Profesor("Sofía López");
        
        escuela.agregarProfesor(prof1);
        escuela.agregarProfesor(prof2);
        
        escuela.agregarAula("Matemáticas", prof1);
        escuela.agregarAula("Historia", prof2);
        
        escuela.iniciarClases();
    }
}
