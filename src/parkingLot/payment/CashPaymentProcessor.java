package parkingLot.payment;

import atm.card.CardDetails;

public class CashPaymentProcessor implements IPaymentProcessor{
    private final double amount;

    public CashPaymentProcessor(double amount) {
        this.amount = amount;
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
