import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class SistemaDeNotificaciones {

    private List<Notificacion> notificaciones;

    public SistemaDeNotificaciones() {
        this.notificaciones = new ArrayList<>();
    }

    // Agregar notificación
    public void agregarNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }

    // Filtrar notificaciones por prioridad
    public List<Notificacion> filtrarPorPrioridad(Prioridad prioridad) {
        return notificaciones.stream()
                .filter(n -> n.getPrioridad() == prioridad)
                .collect(Collectors.toList());
    }

    // Filtrar notificaciones por categoría
    public List<Notificacion> filtrarPorCategoria(Categoria categoria) {
        return notificaciones.stream()
                .filter(n -> n.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    // Filtrar notificaciones no leídas
    public List<Notificacion> filtrarNoLeidas() {
        return notificaciones.stream()
                .filter(n -> !n.isLeida())
                .collect(Collectors.toList());
    }

    // Filtrar notificaciones vencidas
    public List<Notificacion> filtrarVencidas() {
        Date ahora = new Date();
        return notificaciones.stream()
                .filter(n -> n.getFechaVencimiento().before(ahora))
                .collect(Collectors.toList());
    }

    // Ordenar notificaciones por fecha
    public List<Notificacion> ordenarPorFecha() {
        return notificaciones.stream()
                .sorted(Comparator.comparing(Notificacion::getFecha))
                .collect(Collectors.toList());
    }

    // Agrupar notificaciones por prioridad
    public Map<Prioridad, List<Notificacion>> agruparPorPrioridad() {
        return notificaciones.stream()
                .collect(Collectors.groupingBy(Notificacion::getPrioridad));
    }

    // Marcar todas las notificaciones como leídas
    public void marcarTodasComoLeidas() {
        notificaciones.forEach(Notificacion::marcarComoLeida);
    }

    // Mostrar notificaciones
    public void mostrarNotificaciones(List<Notificacion> notificaciones) {
        notificaciones.forEach(System.out::println);
    }
}
