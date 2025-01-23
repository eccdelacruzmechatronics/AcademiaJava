class CreditCardPayment implements Payment {
    private double amount;
    private String currency;
    private String cardNumber;

    public CreditCardPayment(double amount, String currency, String cardNumber) {
        this.amount = amount;
        this.currency = currency;
        this.cardNumber = cardNumber;
    }

    @Override
    public void validate() {
        System.out.println("Validando tarjeta de crédito: " + cardNumber);
    }

    @Override
    public void applyDiscount() {
        System.out.println("Aplicando 5% de descuento para tarjeta de crédito.");
        amount *= 0.95; // Aplicar descuento
    }

    @Override
    public void convertCurrency() {
        System.out.println("Convirtiendo " + amount + " " + currency + " a la moneda local...");
    }

    @Override
    public void executePayment() {
        System.out.println("Procesando pago de $" + amount + " con tarjeta de crédito.");
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
        System.out.println("Registrando el pago con tarjeta de crédito en el sistema.");
    }
}