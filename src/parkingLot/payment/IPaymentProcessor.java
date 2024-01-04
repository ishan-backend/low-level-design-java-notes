package parkingLot.payment;

public interface IPaymentProcessor {
    public boolean executePayment();
    public double getAmount(); // for Strict data validation at server level
}
