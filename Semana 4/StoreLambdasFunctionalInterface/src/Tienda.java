import java.util.*;
import java.util.function.*;

public class Tienda {

    // 1. Predicate: Filtrar productos con precio mayor a 500
    public static List<Producto> filtrarProductos(List<Producto> lista, Predicate<Producto> criterio) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : lista) {
            if (criterio.test(p)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // 2. Function: Aplicar descuento del 10% a un producto
    public static Function<Producto, Double> calcularDescuento = p -> p.getPrecio() * 0.9;

    // 3. Consumer: Mostrar detalles de los productos
    public static Consumer<Producto> mostrarProducto = p -> System.out.println("Producto: " + p.getNombre() + ", Precio: " + p.getPrecio());

    // 4. Supplier: Generar un producto por defecto
    public static Supplier<Producto> generarProducto = () -> new Producto("Producto Genérico", "General", 100);

    // 5. UnaryOperator: Aumentar el precio de todos los productos en 10%
    public static UnaryOperator<Producto> aumentarPrecio = p -> new Producto(p.getNombre(), p.getCategoria(), p.getPrecio() * 1.10);

    // 6. BinaryOperator: Combinar precios de dos productos
    public static BinaryOperator<Producto> combinarPrecios = (p1, p2) -> new Producto(
        "Producto Combinado",
        p1.getCategoria(),
        p1.getPrecio() + p2.getPrecio()
    );
}
