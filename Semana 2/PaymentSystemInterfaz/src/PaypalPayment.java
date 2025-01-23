class PayPalPayment implements Payment {
    private double amount;
    private String currency;
    private String email;

    public PayPalPayment(double amount, String currency, String email) {
        this.amount = amount;
        this.currency = currency;
        this.email = email;
    }

    @Override
    public void validate() {
        System.out.println("Validando cuenta PayPal: " + email);
    }

    @Override
    public void applyDiscount() {
        System.out.println("Aplicando 10% de descuento para PayPal.");
        amount *= 0.90; // Aplicar descuento
    }

    @Override
    public void convertCurrency() {
        System.out.println("Convirtiendo " + amount + " " + currency + " a la moneda local...");
    }

    @Override
    public void executePayment() {
        System.out.println("Procesando pago de $" + amount + " con PayPal.");
    }

    @Override
    public void verifyFraud() {
        System.out.println("Verificando fraude para cuenta PayPal.");
    }

    @Override
    public void generateReceipt() {
        System.out.println("Recibo generado para el pago con PayPal.");
    }

    @Override
    public void logPayment() {
        System.out.println("Registrando el pago con PayPal en el sistema.");
    }
}