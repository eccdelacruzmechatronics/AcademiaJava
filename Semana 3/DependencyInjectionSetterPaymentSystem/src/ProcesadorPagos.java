// 4. Clase que usa un método de pago (Servicio de Pagos)
class ProcesadorPagos {
    private MetodoPago metodoPago;

    // Setter para inyectar la dependencia después
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void realizarPago(double monto) {
        if (metodoPago == null) {
            throw new IllegalStateException("El método de pago no ha sido configurado");
        }
        metodoPago.procesarPago(monto);
    }
}