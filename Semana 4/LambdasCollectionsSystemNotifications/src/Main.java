import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear el sistema de notificaciones
        SistemaDeNotificaciones sistema = new SistemaDeNotificaciones();

        // Crear algunas notificaciones
        System.out.println(" --- Cargando Notificaciones ---");
        sistema.agregarNotificacion(new Notificacion("Mensaje urgente de seguridad", Prioridad.ALTA, Categoria.URGENTE, new Date(2023, 5, 15), new Date(2023, 5, 20)));
        sistema.agregarNotificacion(new Notificacion("Recordatorio de reunión", Prioridad.MEDIA, Categoria.RECORDATORIO, new Date(2023, 5, 18), new Date(2023, 5, 25)));
        sistema.agregarNotificacion(new Notificacion("Promoción del producto", Prioridad.BAJA, Categoria.PROMOCION, new Date(2023, 5, 10), new Date(2023, 5, 30)));
        sistema.agregarNotificacion(new Notificacion("Actualización del sistema", Prioridad.ALTA, Categoria.SISTEMA, new Date(2023, 5, 19), new Date(2023, 5, 21)));
        
        // Filtrar y mostrar notificaciones de alta prioridad
        List<Notificacion> altaPrioridad = sistema.filtrarPorPrioridad(Prioridad.ALTA);
        System.out.println(" --- Notificaciones de alta prioridad: ---");
        sistema.mostrarNotificaciones(altaPrioridad);

        // Filtrar y mostrar notificaciones no leídas
        List<Notificacion> noLeidas = sistema.filtrarNoLeidas();
        System.out.println("--- Notificaciones no leídas: ---");
        sistema.mostrarNotificaciones(noLeidas);

        // Ordenar y mostrar las notificaciones por fecha
        List<Notificacion> ordenadas = sistema.ordenarPorFecha();
        System.out.println("--- Notificaciones ordenadas por fecha: ---");
        sistema.mostrarNotificaciones(ordenadas);

        // Agrupar las notificaciones por prioridad y mostrar
        Map<Prioridad, List<Notificacion>> agrupadasPorPrioridad = sistema.agruparPorPrioridad();
        System.out.println("--- Notificaciones agrupadas por prioridad: ---");
        agrupadasPorPrioridad.forEach((prioridad, notificaciones) -> {
            System.out.println(prioridad + ":");
            sistema.mostrarNotificaciones(notificaciones);
        });

        // Marcar todas las notificaciones como leídas
        sistema.marcarTodasComoLeidas();
        System.out.println("Todas las notificaciones han sido marcadas como leídas.");
    }
}
