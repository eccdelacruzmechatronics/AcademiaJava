import java.util.*;

public class Notificacion {
    private String mensaje;
    private Prioridad prioridad;
    private Categoria categoria;
    private Date fecha;
    private boolean leida;
    private Date fechaVencimiento;

    public Notificacion(String mensaje, Prioridad prioridad, Categoria categoria, Date fecha, Date fechaVencimiento) {
        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.categoria = categoria;
        this.fecha = fecha;
        this.fechaVencimiento = fechaVencimiento;
        this.leida = false;
    }

    public String getMensaje() { return mensaje; }
    public Prioridad getPrioridad() { return prioridad; }
    public Categoria getCategoria() { return categoria; }
    public Date getFecha() { return fecha; }
    public boolean isLeida() { return leida; }
    public Date getFechaVencimiento() { return fechaVencimiento; }

    public void marcarComoLeida() {
        this.leida = true;
    }

    @Override
    public String toString() {
        return "Notificación{" +
                "mensaje='" + mensaje + '\'' +
                ", prioridad=" + prioridad +
                ", categoria=" + categoria +
                ", fecha=" + fecha +
                ", leida=" + leida +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}
