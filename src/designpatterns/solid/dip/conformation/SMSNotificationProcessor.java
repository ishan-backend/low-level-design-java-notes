package designpatterns.solid.dip.conformation;

public class SMSNotificationProcessor implements NotificationProcessor{
    @Override
    public void sendNotification(int productId, int customerId) {
        System.out.println("SMS notification processing");
    }
}
