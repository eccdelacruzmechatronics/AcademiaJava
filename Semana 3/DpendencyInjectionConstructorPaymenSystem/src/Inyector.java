// 5. Clase Inyector que decide qué método de pago usar
class Inyector {
    public static ProcesadorPagos proporcionarProcesadorPagos(String tipo) {
        MetodoPago metodoPago;
        
        if ("tarjeta".equalsIgnoreCase(tipo)) {
            metodoPago = new PagoTarjeta();
        } 
        else if ("paypal".equalsIgnoreCase(tipo)) {
            metodoPago = new PagoPayPal();
        } 
        else if ("applepay".equalsIgnoreCase(tipo)) {
            metodoPago = new PagoApplePay();
        } 
        else if ("MP".equalsIgnoreCase(tipo)) {
            metodoPago = new PagoMercadoPago();
        } 
        
        else {
            throw new IllegalArgumentException("Método de pago no válido");
        }

        return new ProcesadorPagos(metodoPago);
    }
}