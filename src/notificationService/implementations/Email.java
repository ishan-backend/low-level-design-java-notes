package notificationService.implementations;

public class Email implements NotificationSender{
    @Override
    public void sendNotification() {
        System.out.println("email sent");
    }
}
