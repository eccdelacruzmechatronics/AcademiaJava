public class PaymentSystem {
    public static void main(String[] args) {
        // Crear diferentes métodos de pago
        Payment creditCardPayment = new CreditCardPayment(300.0, "USD", "1234-5678-9012-3456");
        Payment payPalPayment = new PayPalPayment(700.0, "EUR", "ecc@egmail.com");

        // Procesar los pagos
        System.out.println("Procesando pago con tarjeta de crédito:");
        creditCardPayment.processPayment();
        System.out.println();

        System.out.println("Procesando pago con PayPal:");
        payPalPayment.processPayment();
    }
}