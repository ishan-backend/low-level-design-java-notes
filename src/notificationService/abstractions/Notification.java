package notificationService.abstractions;

import notificationService.implementations.NotificationSender;

public abstract class Notification { // has NotificationSender(email, WA etc), while extensions of Notification is textMessage etc
    NotificationSender notificationSender;

    public Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    abstract void send();
}
