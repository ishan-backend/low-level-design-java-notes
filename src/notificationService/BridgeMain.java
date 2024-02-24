package notificationService;

import notificationService.abstractions.TextMessageNotification;
import notificationService.implementations.Email;

public class BridgeMain {
    public static void main(String[] args) {
        TextMessageNotification textMessage = new TextMessageNotification(new Email());
        textMessage.send();
    }
}
