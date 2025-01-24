// Interfaz Payment que define el contrato para cualquier método de pago
interface Payment {
    void validate();
    void applyDiscount();
    void convertCurrency();
    void executePayment();
    void verifyFraud();
    void generateReceipt();
    void logPayment();

    // Método por defecto que ejecuta el flujo completo del pago
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