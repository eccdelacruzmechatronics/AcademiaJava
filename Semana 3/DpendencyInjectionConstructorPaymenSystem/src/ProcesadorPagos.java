// 4. Clase que usa un método de pago (Servicio de Pagos)
class ProcesadorPagos {
    private final MetodoPago metodoPago;

    // Inyección de dependencias por constructor
    public ProcesadorPagos(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void realizarPago(double monto) {
        metodoPago.procesarPago(monto);
    }
}