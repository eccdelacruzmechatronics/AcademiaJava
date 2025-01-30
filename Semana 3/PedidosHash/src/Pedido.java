
import java.util.Objects;


class Pedido {
    private int idPedido;
    private String cliente;
    private double montoTotal;

    public Pedido(int idPedido, String cliente, double montoTotal) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
    }
    public int getIdPedido() {
        return idPedido;
    }

    // Sobrescribir equals para evitar duplicados en el HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return idPedido == pedido.idPedido; // Se compara solo el ID del pedido
    }

    // Sobrescribir hashCode para asegurar unicidad en el HashSet
    @Override
    public int hashCode() {
        return Objects.hash(idPedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "ID=" + idPedido +
                ", Cliente='" + cliente + '\'' +
                ", Monto=$" + montoTotal +
                '}';
    }
}
