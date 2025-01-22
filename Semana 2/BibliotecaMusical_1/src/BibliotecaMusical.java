
import java.util.ArrayList;
import java.util.Scanner;



class Cancion {
    private String titulo;
    private String artista;
    private String genero;

    public Cancion(String titulo, String artista, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Artista: " + artista + ", Género: " + genero;
    }
}

public class BibliotecaMusical {
    private ArrayList<Cancion> biblioteca;

    public BibliotecaMusical() {
        biblioteca = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        biblioteca.add(cancion);
        System.out.println("Canción agregada: " + cancion.getTitulo());
    }

    public void listarCanciones() {
        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
        } else {
            System.out.println("Canciones en la biblioteca:");
            for (Cancion cancion : biblioteca) {
                System.out.println(cancion);
            }
        }
    }

    public void buscarPorTitulo(String titulo) {
        boolean encontrada = false;
        for (Cancion cancion : biblioteca) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Canción encontrada: " + cancion);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontró ninguna canción con el título: " + titulo);
        }
    }

    public void buscarPorArtista(String artista) {
        boolean encontrada = false;
        for (Cancion cancion : biblioteca) {
            if (cancion.getArtista().equalsIgnoreCase(artista)) {
                System.out.println("Canción encontrada: " + cancion);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontró ninguna canción del artista: " + artista);
        }
    }


	public static void main(String[] args) {
        BibliotecaMusical biblioteca = new BibliotecaMusical();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Biblioteca Musical ---");
            System.out.println("1. Agregar canción");
            System.out.println("2. Listar canciones");
            System.out.println("3. Buscar canción por título");
            System.out.println("4. Buscar canción por artista");
            System.out.println("5. Salir");
            System.out.print("Introduzca su opción seleccionada: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();
                    biblioteca.agregarCancion(new Cancion(titulo, artista, genero));
                    break;
                case 2:
                    biblioteca.listarCanciones();
                    break;
                case 3:
                    System.out.print("Introduce el título a buscar: ");
                    String tituloBusqueda = scanner.nextLine();
                    biblioteca.buscarPorTitulo(tituloBusqueda);
                    break;
                case 4:
                    System.out.print("Introduce el artista a buscar: ");
                    String artistaBusqueda = scanner.nextLine();
                    biblioteca.buscarPorArtista(artistaBusqueda);
                    break;
                case 5:
                    System.out.println("¡Gracias por usar la Biblioteca Musical!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

}

