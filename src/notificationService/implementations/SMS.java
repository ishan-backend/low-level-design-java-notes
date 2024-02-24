package notificationService.implementations;

public class SMS implements NotificationSender{
    @Override
    public void sendNotification() {
        System.out.println("we are going to send SMS");
    }
}
