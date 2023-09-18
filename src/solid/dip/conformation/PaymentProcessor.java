package solid.dip.conformation;

public interface PaymentProcessor {
    void processPayment(int productId, int customerId);
}
