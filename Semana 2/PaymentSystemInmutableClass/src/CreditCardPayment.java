class CreditCardPayment implements Payment {
    private final PaymentDetails paymentDetails; // Objeto inmutable para los detalles del pago
    private final String cardNumber; // Número de tarjeta de crédito

    public CreditCardPayment(PaymentDetails paymentDetails, String cardNumber) {
        this.paymentDetails = paymentDetails;
        this.cardNumber = cardNumber;
    }

    @Override
    public void validate() {
        System.out.println("Validando tarjeta de crédito: " + cardNumber);
    }

    @Override
    public void applyDiscount() {
        System.out.println("Aplicando 5% de descuento para tarjeta de crédito.");
    }

    @Override
    public void convertCurrency() {
        System.out.println("Convirtiendo " + paymentDetails.getAmount() + " " + paymentDetails.getCurrency() + " a la moneda local...");
    }

    @Override
    public void executePayment() {
        System.out.println("Procesando pago de $" + paymentDetails.getAmount() + " con tarjeta de crédito.");
    }

    @Override
    public void verifyFraud() {
        System.out.println("Verificando fraude para tarjeta de crédito.");
    }

    @Override
    public void generateReceipt() {
        System.out.println("Recibo generado para el pago con tarjeta de crédito.");
    }

    @Override
    public void logPayment() {
        System.out.println("Registrando el pago con tarjeta de crédito: " + paymentDetails);
    }
}