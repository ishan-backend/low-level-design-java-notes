package googleDocs;

import java.util.ArrayList;
import java.util.List;

public class WebSocketServer {
    private List<User> users;

    public WebSocketServer() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void notifyAllUsers(User user, String newText) {
        for (User u : users) {
            if (!u.getId().equals(user.getId())) {
                u.receiveDocumentUpdate(newText); // Simulate real-time collaboration

            }
        }
    }
}
