
public class PaymentSystem {

	 public static void main(String[] args) {
	        Payment creditCardPayment = new CreditCardPayment(100.0, "USD", "1234-5678-9012-3456");
	        Payment payPalPayment = new PayPalPayment(200.0, "EUR", "ecc@gmail.com");
	        Payment MercadoPagoPayment = new MercadoPagoPayment(500.0, "CAD", "246XXXXXXX");

	        System.out.println("Procesando pago con tarjeta de crédito:");
	        creditCardPayment.processPayment();
	        System.out.println();

	        System.out.println("Procesando pago con PayPal:");
	        payPalPayment.processPayment();
	        
	        System.out.println("Procesando pago con Mercado Pago:");
	        MercadoPagoPayment.processPayment();
	        
	        
	    }
	}
