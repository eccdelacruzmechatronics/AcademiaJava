import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Arrays.asList(
            new Producto("Laptop", "Electrónica", 1500),
            new Producto("Celular Samsung", "Electrónica", 800),
            new Producto("Zapatos", "Moda", 50),
            new Producto("Camiseta", "Moda", 20),
            new Producto("Refrigerador", "Electrodomésticos", 1200)
        );

        
        System.out.println("BIENVENIDO(A) A LA TIENDA EN LINEA");
        // 1. Filtrar productos caros (precio > 500)
        Predicate<Producto> esCaro = p -> p.getPrecio() > 500;
        List<Producto> productosCaros = Tienda.filtrarProductos(productos, esCaro);
        System.out.println("Productos caros: " + productosCaros);

        // 2. Calcular descuento del 10% para la Laptop
        System.out.println("Precio con descuento de Laptop: " + Tienda.calcularDescuento.apply(productos.get(0)));

        // 3. Mostrar detalles de los productos
        productos.forEach(Tienda.mostrarProducto);

        // 4. Generar un producto por defecto
        System.out.println("Producto generado: " + Tienda.generarProducto.get());

        // 5. Aumentar el precio de todos los productos en un 10%
        List<Producto> productosAumentados = new ArrayList<>();
        productos.forEach(p -> productosAumentados.add(Tienda.aumentarPrecio.apply(p)));
        System.out.println("Productos con aumento de precio: " + productosAumentados);

        // 6. Combinar precios de la Laptop y el Celular
        Producto productoCombinado = Tienda.combinarPrecios.apply(productos.get(0), productos.get(1));
        System.out.println("Producto combinado: " + productoCombinado);
    }
}
