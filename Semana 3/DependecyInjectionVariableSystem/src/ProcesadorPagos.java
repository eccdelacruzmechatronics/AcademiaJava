class ProcesadorPagos {
    private MetodoPago metodoPago;

    // Constructor define el método de pago sin recibirlo como parámetro (inyección por variable)
    public ProcesadorPagos(String tipoPago) {
        if ("tarjeta".equalsIgnoreCase(tipoPago)) {
            this.metodoPago = new PagoTarjeta();
        } else if ("paypal".equalsIgnoreCase(tipoPago)) {
            this.metodoPago = new PagoPayPal();
        } else {
            throw new IllegalArgumentException("Método de pago no válido");
        }
    }

    public void realizarPago(double monto) {
        metodoPago.procesarPago(monto);
    }
}