import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase inmutable para representar los detalles del pago
final class PaymentDetails {
    private final double amount; // Monto del pago
    private final String currency; // Moneda del pago
    private final String customerId; // ID del cliente
    private final List<String> paymentNotes; // Notas o detalles adicionales del pago (inmutable)

    // Constructor para inicializar todos los atributos
    public PaymentDetails(double amount, String currency, String customerId, List<String> paymentNotes) {
        this.amount = amount;
        this.currency = currency;
        this.customerId = customerId;

        // Creamos una lista inmutable a partir de la lista proporcionada
        this.paymentNotes = paymentNotes == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(paymentNotes));
    }

    // Métodos getter para acceder a los atributos (no hay setters, la clase es inmutable)
    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCustomerId() {
        return customerId;
    }

    // Retorna una lista inmutable de notas de pago
    public List<String> getPaymentNotes() {
        return paymentNotes;
    }

    // Método toString para mostrar los detalles del pago
    @Override
    public String toString() {
        return "PaymentDetails{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", customerId='" + customerId + '\'' +
                ", paymentNotes=" + paymentNotes +
                '}';
    }
}