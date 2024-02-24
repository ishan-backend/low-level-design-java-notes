package notificationService.implementations;


public interface NotificationSender { // Any sender we implement will implement this interface and thus create a way to send notification
    void sendNotification();
}
