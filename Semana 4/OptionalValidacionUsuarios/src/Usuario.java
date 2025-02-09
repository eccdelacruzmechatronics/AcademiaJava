import java.util.Optional;

class Usuario {
    private Optional<String> nombre;  // Ahora nombre también es Optional
    private Optional<String> email;
    private Optional<Integer> edad;

    public Usuario(String nombre, String email, Integer edad) {
        this.nombre = Optional.ofNullable(nombre);
        this.email = Optional.ofNullable(email);
        this.edad = Optional.ofNullable(edad);
    }

    public Optional<String> getNombre() {
        return nombre;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public Optional<Integer> getEdad() {
        return edad;
    }
}

