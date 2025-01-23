class MercadoPagoPayment extends Payment {
    private String cellphone;

    public MercadoPagoPayment(double amount, String currency, String cellphone ) {
        super(amount, currency);
        this.cellphone = cellphone;
    }

    @Override
    protected void validate() {
        System.out.println("Validando cuenta PayPal: " + cellphone);
    }

    @Override
    protected void executePayment() {
        System.out.println("Procesando pago de $" + getAmount() + " con Mercado Pago.");
    }

    @Override
    protected void generateReceipt() {
        System.out.println("Redirigiendo a Paypal para generar recibo");
    }

    @Override
    protected void verifyFraud() {
        System.out.println("Verificando fraude para cuenta Mercado Pago.");
    }

    @Override
    protected void applyDiscount() {
        System.out.println("Aplicando 10% de descuento para Mercado Pago.");
    }
}