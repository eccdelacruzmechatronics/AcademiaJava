import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TryWithResourceFile {
	public static void main(String[] args) {
        // Usar Scanner para leer del teclado
        try (Scanner scanner = new Scanner(System.in);
             // Usar BufferedWriter para escribir en un archivo
             BufferedWriter writer = new BufferedWriter(new FileWriter("salida.txt"))) {

            System.out.println("Escribe texto para guardar en el archivo (escribe 'salir' para terminar):");

            while (true) {
                String input = scanner.nextLine(); // Leer línea desde el teclado

                if ("salir".equalsIgnoreCase(input)) { // Si el usuario escribe "salir", termina el bucle, sin importar si son mayús o min 
                    System.out.println("Finalizando escritura...");
                    break;
                }

                writer.write(input); // Escribir el texto en el archivo
                writer.newLine();   // Añadir una nueva línea
                System.out.println("Texto guardado.");
            }

        } catch (IOException e) {
            // Manejo de excepciones para errores de entrada/salida
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }

        System.out.println("Programa finalizado.");
    }
}
