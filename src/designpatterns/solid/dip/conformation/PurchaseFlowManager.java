package designpatterns.solid.dip.conformation;

public class PurchaseFlowManager {
    private final PaymentProcessor paymentProcessor;
    private final NotificationProcessor notificationProcessor;


    public PurchaseFlowManager(PaymentProcessor paymentProcessor, NotificationProcessor notificationProcessor) {
        this.paymentProcessor = paymentProcessor;
        this.notificationProcessor = notificationProcessor;
    }

    public void triggerPurchaseFlow(int productId, int customerId) {
        paymentProcessor.processPayment(productId, customerId);
        notificationProcessor.sendNotification(productId, customerId);
    }
}
