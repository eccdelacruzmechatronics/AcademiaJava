import java.util.HashSet;

import java.util.Set;

class GestorPedidos {
    private Set<Pedido> pedidos;

    public GestorPedidos() {
        this.pedidos = new HashSet<>();
    }

    // Agregar pedido (si no existe con el mismo ID)
    public void agregarPedido(Pedido pedido) {
        if (pedidos.add(pedido)) {
            System.out.println("Pedido agregado: " + pedido);
        } else {
            System.out.println("El pedido con ID " + pedido.getIdPedido() + " ya existe.");
        }
    }

    // Mostrar todos los pedidos
    public void mostrarPedidos() {
        System.out.println("\nLista de pedidos registrados:");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
}