public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Carlos", "carlos@gmail.com", 25);
        Usuario usuario2 = new Usuario("Ana", null, 17);
        Usuario usuario3 = new Usuario("Pedro", "pedro@hotmail.com", null);
        Usuario usuario4 = new Usuario(null, null, null);

        mostrarInfoUsuario(usuario1);
        mostrarInfoUsuario(usuario2);
        mostrarInfoUsuario(usuario3);
        mostrarInfoUsuario(usuario4);
    }
    public static void mostrarInfoUsuario(Usuario usuario) {
        System.out.println("\n🔹 Usuario:");

        // orElseThrow() → Lanza error si el nombre no está presente.
        String nombre = usuario.getNombre()
                .orElseThrow(() -> new IllegalArgumentException("Error: El usuario no tiene nombre."));
        System.out.println("Nombre: " + nombre);

        // ifPresent() → Imprime email si está presente.
        usuario.getEmail().ifPresent(email -> System.out.println("Email: " + email));

        // orElseGet() → Genera un email por defecto si no tiene.
        String emailGenerado = usuario.getEmail().orElseGet(() -> nombre.toLowerCase() + "@default.com");
        System.out.println("Email generado (si no tenía): " + emailGenerado);

        // map() → Convierte la edad en un mensaje.
        String mensajeEdad = usuario.getEdad()
                .map(edad -> "Usuario tiene " + edad + " años.")
                .orElse("No se ha registrado la edad.");
        System.out.println(mensajeEdad);

        // filter() → Verifica si el usuario es mayor de edad.
        String mayoriaEdad = usuario.getEdad()
                .filter(edad -> edad >= 18)
                .map(edad -> "✅ Usuario es mayor de edad.")
                .orElse("❌ Usuario es menor de edad o no tiene edad registrada.");
        System.out.println(mayoriaEdad);
    }

}
