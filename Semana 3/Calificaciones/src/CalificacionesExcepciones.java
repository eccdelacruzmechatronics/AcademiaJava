import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CalificacionesExcepciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double PROMEDIO_MINIMO = 6.0; // Promedio mínimo permitido
        final double PROMEDIO_MAX = 10.0;

        try {
            System.out.print("Ingrese la fecha (formato yyyy-MM-dd): ");
            String fecha = scanner.nextLine();
            validarFecha(fecha);

            System.out.print("Ingrese el número de calificaciones: ");
            String inputCantidad = scanner.nextLine();
            int cantidad = Integer.parseInt(inputCantidad); // Unchecked: NumberFormatException

            if (cantidad <= 0) {
                throw new ArithmeticException("El número de calificaciones debe ser mayor a 0."); // Unchecked: ArithmeticException
            }

            double[] calificaciones = new double[cantidad];
            double suma = 0;

            for (int i = 0; i < cantidad; i++) {
                System.out.print("Ingrese la calificación " + (i + 1) + ": ");
                calificaciones[i] = Double.parseDouble(scanner.nextLine()); // Unchecked: NumberFormatException
                suma += calificaciones[i];
            }

            double promedio = suma / cantidad; // Unchecked: Puede generar ArithmeticException si  se introduce una cantidad =  0
            System.out.printf("El promedio de las calificaciones es: %.2f%n", promedio);

            validarPromedio(promedio, PROMEDIO_MINIMO, PROMEDIO_MAX); // Checked: Lanza una excepción personalizada si el promedio es muy bajo

        } catch (ParseException e) {
            System.err.println("Error: Fecha en formato incorrecto. Por favor, use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada no válida. Asegúrese de ingresar números.");
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (PromedioBajoException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }

    // Método para validar la fecha (Checked: ParseException)
    public static void validarFecha(String fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.setLenient(false);
        formato.parse(fecha);
    }

    // Método para validar el promedio (Checked: PromedioBajoException)
    public static void validarPromedio(double promedio, double minimoPermitido, double maximoPermitido) throws PromedioBajoException {
        if (promedio < minimoPermitido || promedio >10 ) {
            throw new PromedioBajoException("El promedio  se sale del rango permitido " + minimoPermitido + " a " + maximoPermitido);
        }
    }

    // Clase  para manejar excepción de promedio bajo
    static class PromedioBajoException extends Exception {
        public PromedioBajoException(String mensaje) {
            super(mensaje);
        }
    }
}
