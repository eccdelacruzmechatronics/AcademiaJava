// 1. Definir la interfaz para los métodos de pago
interface MetodoPago {
    void procesarPago(double monto);
}

// 2. Implementación para Tarjeta de Crédito
class PagoTarjeta implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("💳 Pago de $" + monto + " procesado con Tarjeta de Crédito.");
    }
}

// 3. Implementación para PayPal
class PagoPayPal implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("🅿️ Pago de $" + monto + " procesado con PayPal.");
    }
}
    
class PagoMercadoPago implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("🅿️ Pago de $" + monto + " procesado con Mercado Pago.");
        }    
    
}

class PagoApplePay implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("🅿️ Pago de $" + monto + " procesado con Apple Pay.");
        }    
    
}