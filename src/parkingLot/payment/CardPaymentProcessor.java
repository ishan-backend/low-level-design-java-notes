package parkingLot.payment;

import atm.card.CardDetails;

public class CardPaymentProcessor implements IPaymentProcessor {
    private final double amount;
    private final CardDetails cardDetails;

    public CardPaymentProcessor(double amount, CardDetails cardDetails) {
        this.amount = amount;
        this.cardDetails = cardDetails;
    }

    @Override
    public boolean executePayment() {
        return false;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
