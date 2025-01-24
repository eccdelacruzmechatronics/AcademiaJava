// Clase inmutable para representar los detalles del pago
final class PaymentDetails { //se declara como final para no poderla modificar mas adelante
    private final double amount; // Monto del pago
    private final String currency; // Moneda del pago
    private final String customerId; // ID del cliente declarados como private y final para que no sean accesibles despues de incializarlos

    // Constructor para inicializar todos los atributos
    public PaymentDetails(double amount, String currency, String customerId) {
        this.amount = amount;
        this.currency = currency;
        this.customerId = customerId;
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

    // Método toString para mostrar los detalles del pago
    @Override
    public String toString() {
        return "PaymentDetails{amount=" + amount + ", currency='" + currency + '\'' + ", customerId='" + customerId + '\'' + '}';
    }
}