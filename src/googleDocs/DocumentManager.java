package googleDocs;

import java.util.HashMap;
import java.util.Map;

public class DocumentManager {
    private static DocumentManager instance;
    private Document document;
    private Map<String, User> users;

    private DocumentManager() {
        document = new Document();
        users = new HashMap<>();
    }

    public static DocumentManager getInstance() {
        if (instance == null) {
            instance = new DocumentManager();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(User user) {
        users.remove(user.getId());
    }

    public Document getDocument() {
        return document;
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
