public class Main {
    public static void main(String[] args) {
        GestorPedidos gestor = new GestorPedidos();

        Pedido p1 = new Pedido(101, "Cliente A", 250.75);
        Pedido p2 = new Pedido(102, "Cliente B", 320.50);
        Pedido p3 = new Pedido(101, "Cliente C", 150.00); // Mismo ID que p1

        gestor.agregarPedido(p1);
        gestor.agregarPedido(p2);
        gestor.agregarPedido(p3); // No se añadirá porque el ID ya existe

        gestor.mostrarPedidos();
    }
}