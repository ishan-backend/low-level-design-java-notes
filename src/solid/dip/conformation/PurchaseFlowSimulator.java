package solid.dip.conformation;

public class PurchaseFlowSimulator {
    public static void main(String []args) {
        PurchaseFlowManager purchaseFlowManager = new PurchaseFlowManager(new NetBankingPaymentProcessor(), new SMSNotificationProcessor());
        purchaseFlowManager.triggerPurchaseFlow(1, 2);

        PurchaseFlowManager purchaseFlowManager2 = new PurchaseFlowManager(new UPIPaymentProcessor(), new SMSNotificationProcessor());
        purchaseFlowManager2.triggerPurchaseFlow(2, 3);
    }
}
