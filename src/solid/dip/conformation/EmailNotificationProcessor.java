package solid.dip.conformation;

public class EmailNotificationProcessor implements NotificationProcessor{
    @Override
    public void sendNotification(int productId, int customerId) {
        System.out.println("Email notification processing");
    }
}
