abstract class Payment {
    private double amount;
    private String currency;

    public Payment(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void processPayment() {
        validate();
        applyDiscount();
        convertCurrency();
        executePayment();
        verifyFraud();
        generateReceipt();
        logPayment();
    }

    protected abstract void validate();
    protected abstract void executePayment();
    protected abstract void generateReceipt();
    protected abstract void verifyFraud();

    protected void applyDiscount() {
        System.out.println("Aplicando descuentos generales...");
    }

    protected void convertCurrency() {
        System.out.println("Convirtiendo " + amount + " " + currency + " a MXN ...");
    }

    protected void logPayment() {
        System.out.println("Registrando el pago en el sistema.");
    }
}