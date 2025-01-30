// 5. Clase Inyector que se encarga de la creación de las dependencias
class Inyector {
    public static ProcesadorPagos proporcionarProcesadorPagos(String tipo) {
        MetodoPago metodoPago;
        
        if ("tarjeta".equalsIgnoreCase(tipo)) {
            metodoPago = new PagoTarjeta();
        } else if ("paypal".equalsIgnoreCase(tipo)) {
            metodoPago = new PagoPayPal();
        } else {
            throw new IllegalArgumentException("Método de pago no válido");
        }

        ProcesadorPagos procesador = new ProcesadorPagos();
        procesador.setMetodoPago(metodoPago);  // Inyección por Setter
        return procesador;
    }
}
