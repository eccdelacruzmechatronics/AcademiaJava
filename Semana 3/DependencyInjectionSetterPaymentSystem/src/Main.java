//6. CÓDIGO PRINCIPAL
public class Main {
    public static void main(String[] args) {
        // Obtener el ProcesadorPagos con el método de pago que deseamos
        ProcesadorPagos procesadorTarjeta = Inyector.proporcionarProcesadorPagos("tarjeta");
        ProcesadorPagos procesadorPayPal = Inyector.proporcionarProcesadorPagos("paypal");

        // Realizar pagos con diferentes métodos
        procesadorTarjeta.realizarPago(100.50);  // Pago con tarjeta
        procesadorPayPal.realizarPago(75.25);    // Pago con PayPal
    }
}
