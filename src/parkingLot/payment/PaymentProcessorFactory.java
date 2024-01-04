package parkingLot.payment;

import atm.card.CardDetails;

public class PaymentProcessorFactory {
    private PaymentProcessorFactory(){}

    public static IPaymentProcessor getCashBasedPaymentProcessor(double amount) {
        return new CashPaymentProcessor(amount);
    }

    public static IPaymentProcessor getCardBasedPaymentProcessor(double amount, CardDetails cardDetails) {
        return new CardPaymentProcessor(amount, cardDetails);
    }
}
