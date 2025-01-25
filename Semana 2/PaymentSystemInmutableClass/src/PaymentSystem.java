import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymentSystem {
    public static void main(String[] args) {
    	// Crear una lista de notas de pago
        List<String> notes = new ArrayList<>();
        notes.add("Descuento extra aplicado: 5%");
        notes.add("Pago en una sola exhibición");

        // Crear un objeto PaymentDetails con una lista de notas
        PaymentDetails details = new PaymentDetails(100.0, "CAD", "CustomerECC", notes);

        // Imprimir los detalles del pago
        System.out.println(details);

        // Intentar modificar la lista original (no afecta a la clase inmutable)
        notes.add("Nota adicional: debería ignorarse");
        System.out.println("Después de modificar la lista original:");
        System.out.println(details);

        // Intentar modificar la lista obtenida a través del getter (throws an exception)
        try {
            details.getPaymentNotes().add("Intento de modificación fallido");
        } catch (UnsupportedOperationException e) {
            System.out.println("No se puede modificar la lista inmutable desde el getter.");
        }
    }
}
