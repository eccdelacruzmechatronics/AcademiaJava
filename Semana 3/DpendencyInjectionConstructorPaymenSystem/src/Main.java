// 6. Código principal que usa el inyector de dependencias
public class Main {
    public static void main(String[] args) {
        // Obtener una instancia de ProcesadorPagos con el método deseado
        ProcesadorPagos pagoConTarjeta = Inyector.proporcionarProcesadorPagos("tarjeta");
        ProcesadorPagos pagoConPayPal = Inyector.proporcionarProcesadorPagos("paypal");
        ProcesadorPagos pagoConApplePay = Inyector.proporcionarProcesadorPagos("applepay");
        ProcesadorPagos pagoConMercadoPago = Inyector.proporcionarProcesadorPagos("MP");


        // Realizar pagos con diferentes métodos
        pagoConTarjeta.realizarPago(100.50);
        pagoConPayPal.realizarPago(75.25);
        pagoConMercadoPago.realizarPago(200.50);
        pagoConApplePay.realizarPago(78.0);
    }
}
