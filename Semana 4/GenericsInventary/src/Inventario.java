import java.util.ArrayList;
import java.util.List;

class Inventario<T extends Producto> {  //UPPER BOUNDED GENERICS
    private List<T> productos = new ArrayList<>();  

    public void agregarProducto(T producto) {  
        productos.add(producto);  
    }  

    public void mostrarInventario() {  
        for (T producto : productos) {  
            System.out.println(producto);  
        }  
    }  

    // Método genérico para buscar un producto por nombre UNBOUNDED 
    public <U extends Producto> boolean buscarProducto(U productoBuscado) {  
        for (T producto : productos) {  
            if (producto.getNombre().equalsIgnoreCase(productoBuscado.getNombre())) {  
                return true;  
            }  
        }  
        return false;  
    }  
}
