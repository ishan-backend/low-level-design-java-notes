package notificationService.abstractions;

import notificationService.implementations.NotificationSender;

public class TextMessageNotification extends Notification {
    public TextMessageNotification(NotificationSender notificationSender) { // we add channel to use to send notification using this constructor
        super(notificationSender);
        System.out.println("Text message initialised");
    }
    @Override
    public void send() {
        notificationSender.sendNotification();
    }
}
