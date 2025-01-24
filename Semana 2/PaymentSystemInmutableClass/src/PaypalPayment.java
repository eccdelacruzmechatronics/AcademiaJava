// Implementación para pagos con PayPal
class PaypalPayment implements Payment {
    private final PaymentDetails paymentDetails; // Objeto inmutable para los detalles del pago
    private final String email; // Correo asociado a la cuenta PayPal

    public PaypalPayment(PaymentDetails paymentDetails, String email) {
        this.paymentDetails = paymentDetails;
        this.email = email;
    }

    @Override
    public void validate() {
        System.out.println("Validando cuenta PayPal: " + email);
    }

    @Override
    public void applyDiscount() {
        System.out.println("Aplicando 10% de descuento para PayPal.");
    }

    @Override
    public void convertCurrency() {
        System.out.println("Convirtiendo " + paymentDetails.getAmount() + " " + paymentDetails.getCurrency() + " a la moneda local...");
    }

    @Override
    public void executePayment() {
        System.out.println("Procesando pago de $" + paymentDetails.getAmount() + " con PayPal.");
    }

    @Override
    public void verifyFraud() {
        System.out.println("Verificando fraude para cuenta PayPal.");
    }

    @Override
    public void generateReceipt() {
        System.out.println("Redirigiendo para generar el recibo del pago con PayPal.");
    }

    @Override
    public void logPayment() {
        System.out.println("Registrando el pago con PayPal: " + paymentDetails);
    }
}