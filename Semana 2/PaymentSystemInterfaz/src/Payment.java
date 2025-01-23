// Interfaz Payment que define los métodos obligatorios
interface Payment {
    void validate();
    void applyDiscount();
    void convertCurrency();
    void executePayment();
    void verifyFraud();
    void generateReceipt();
    void logPayment();

    // para procesar todo el flujo de pago
    default void processPayment() {
        validate();
        applyDiscount();
        convertCurrency();
        executePayment();
        verifyFraud();
        generateReceipt();
        logPayment();
    }
}
