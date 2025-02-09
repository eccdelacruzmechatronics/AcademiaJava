public class Main {  
    public static void main(String[] args) {  
        // Crear inventarios específicos  
        Inventario<Electronico> inventarioElectronicos = new Inventario<>();  
        Inventario<Ropa> inventarioRopa = new Inventario<>();  
        Inventario<Comida> inventarioComida = new Inventario<>();  

        System.out.println("📌 Bienvendio al sistema de inventario con categorías como Ropa , comida y electrónicos"); 
        // Agregar productos  
        inventarioElectronicos.agregarProducto(new Electronico("Laptop", 1200, 24));  
        inventarioElectronicos.agregarProducto(new Electronico("Celular", 800, 12));  

        inventarioRopa.agregarProducto(new Ropa("Camisa", 25, "M"));  
        inventarioRopa.agregarProducto(new Ropa("Jeans", 50, "L"));  

        inventarioComida.agregarProducto(new Comida("Leche", 2, "15/02/2025"));  
        inventarioComida.agregarProducto(new Comida("Pan", 1.5, "10/02/2025"));  

        // Mostrar inventarios  
        System.out.println("📌 Inventario de Electrónicos:");  
        inventarioElectronicos.mostrarInventario();  
        
        System.out.println("\n📌 Inventario de Ropa:");  
        inventarioRopa.mostrarInventario();  
        
        System.out.println("\n📌 Inventario de Comida:");  
        inventarioComida.mostrarInventario();  

        // Buscar productos  
        Ropa prendaBuscada = new Ropa("Jeans", 50, "L");  
        boolean encontrado = inventarioRopa.buscarProducto(prendaBuscada);  
        System.out.println("\n🔍 ¿Se encontró 'Jeans' en el inventario de ropa? " + encontrado);  
    }  
}
