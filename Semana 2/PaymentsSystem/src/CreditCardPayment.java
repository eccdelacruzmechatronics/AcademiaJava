class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(double amount, String currency, String cardNumber) {
        super(amount, currency);
        this.cardNumber = cardNumber;
    }

    @Override
    protected void validate() {
        System.out.println("Validando tarjeta de crédito: " + cardNumber);
    }

    @Override
    protected void executePayment() {
        System.out.println("Procesando pago de $" + getAmount() + " con tarjeta de crédito.");
    }

    @Override
    protected void generateReceipt() {
        System.out.println("Recibo generado para el pago con tarjeta de crédito.");
    }

    @Override
    protected void verifyFraud() {
        System.out.println("Verificando fraude para tarjeta de crédito.");
    }

    @Override
    protected void applyDiscount() {
        System.out.println("Aplicando 5% de descuento para tarjeta de crédito.");
    }
}

