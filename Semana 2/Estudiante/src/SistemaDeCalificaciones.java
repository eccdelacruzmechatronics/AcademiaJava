import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeCalificaciones {

    // Lista para almacenar los estudiantes
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú de opciones
        do {
            System.out.println("Sistema de Calificaciones:");
            System.out.println("1. Agregar Alumno");
            System.out.println("2. Agregar Calificación a Alumno");
            System.out.println("3. Mostrar Calificaciones de un Alumno");
            System.out.println("4. Mostrar Todos los Estudiantes");
            System.out.println("5. Eliminar Alumno");
            System.out.println("6. Modificar Alumno");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarAlumno(scanner);
                    break;
                case 2:
                    agregarCalificacion(scanner);
                    break;
                case 3:
                    mostrarCalificacionesAlumno(scanner);
                    break;
                case 4:
                    mostrarTodosEstudiantes();
                    break;
                case 5:
                    eliminarAlumno(scanner);
                    break;
                case 6:
                    modificarAlumno(scanner);
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    // Método para agregar un nuevo alumno
    public static void agregarAlumno(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno (boleta): ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        estudiantes.add(new Estudiante(id, nombre));
        System.out.println("Alumno agregado exitosamente.");
    }

    // Método para agregar una calificación a un alumno
    public static void agregarCalificacion(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno: ");
        String id = scanner.nextLine();

        Estudiante alumno = buscarEstudiante(id);
        if (alumno != null) {
            System.out.print("Ingrese la calificación: ");
            double calificacion = scanner.nextDouble();
            alumno.agregarCalificacion(calificacion);
            System.out.println("Calificación agregada exitosamente.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    // Método para mostrar las calificaciones de un alumno
    public static void mostrarCalificacionesAlumno(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno: ");
        String id = scanner.nextLine();

        Estudiante alumno = buscarEstudiante(id);
        if (alumno != null) {
            System.out.println("Calificaciones de " + alumno.getNombre() + ": " + alumno.getCalificaciones());
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    // Método para mostrar todos los estudiantes y sus calificaciones
    public static void mostrarTodosEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en el sistema.");
        } else {
            for (Estudiante alumno : estudiantes) {
                System.out.println(alumno);
            }
        }
    }

    // Método para eliminar un alumno por su ID
    public static void eliminarAlumno(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno a eliminar: ");
        String id = scanner.nextLine();

        Estudiante alumno = buscarEstudiante(id);
        if (alumno != null) {
            estudiantes.remove(alumno);
            System.out.println("Alumno eliminado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    // Método para modificar los datos de un alumno
    public static void modificarAlumno(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno a modificar: ");
        String id = scanner.nextLine();

        Estudiante alumno = buscarEstudiante(id);
        if (alumno != null) {
            System.out.print("Ingrese el nuevo nombre del alumno: ");
            String nuevoNombre = scanner.nextLine();
            alumno.setNombre(nuevoNombre);
            System.out.println("Nombre del alumno modificado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    // Método para buscar un estudiante por su ID
    public static Estudiante buscarEstudiante(String id) {
        for (Estudiante alumno : estudiantes) {
            if (alumno.getId().equals(id)) {
                return alumno;
            }
        }
        return null;
    }
}

