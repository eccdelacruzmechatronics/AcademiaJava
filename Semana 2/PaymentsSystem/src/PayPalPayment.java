class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(double amount, String currency, String email) {
        super(amount, currency);
        this.email = email;
    }

    @Override
    protected void validate() {
        System.out.println("Validando cuenta PayPal: " + email);
    }

    @Override
    protected void executePayment() {
        System.out.println("Procesando pago de $" + getAmount() + " con PayPal.");
    }

    @Override
    protected void generateReceipt() {
        System.out.println("Redirigiendo a Paypal para generar recibo");
    }

    @Override
    protected void verifyFraud() {
        System.out.println("Verificando fraude para cuenta PayPal.");
    }

    @Override
    protected void applyDiscount() {
        System.out.println("Aplicando 10% de descuento para PayPal.");
    }
}