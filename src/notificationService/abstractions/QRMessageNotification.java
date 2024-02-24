package notificationService.abstractions;

import notificationService.implementations.NotificationSender;

public class QRMessageNotification extends Notification {
    public QRMessageNotification(NotificationSender notificationSender) { // we add channel to use to send notification using this constructor
        super(notificationSender);
        System.out.println("This is QR code"); // add additional fields in this class for QR specific details
    }

    @Override
    void send() {
        // call some method here in this class to build QR code
        notificationSender.sendNotification();
    }
}
