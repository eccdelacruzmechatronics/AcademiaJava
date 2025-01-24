
public class PaymentSystem {
    public static void main(String[] args) {
        // Crear un objeto inmutable para los detalles del pago
        PaymentDetails creditCardDetails = new PaymentDetails(100.0, "USD", "ECC2002");
        PaymentDetails payPalDetails = new PaymentDetails(200.0, "EUR", "ECC2025");

        // Crear diferentes métodos de pago utilizando los detalles
        Payment creditCardPayment = new CreditCardPayment(creditCardDetails, "1234-5678-9012-3456");
        Payment payPalPayment = new PaypalPayment(payPalDetails, "ecc@gmail.com");

        // Procesar los pagos
        System.out.println("Procesando pago con tarjeta de crédito:");
        creditCardPayment.processPayment();
        System.out.println();

        System.out.println("Procesando pago con PayPal:");
        payPalPayment.processPayment();
    }
}
