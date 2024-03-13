package googleDocs;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DocumentManager documentManager = DocumentManager.getInstance();
        WebSocketServer webSocketServer = new WebSocketServer();
        //ProxyAccessControl accessControl = new ProxyAccessControl();

        Document document = documentManager.getDocument();

        User user1 = new NormalUser("user1", document, webSocketServer);
        User user2 = new NormalUser("user2", document, webSocketServer);

        documentManager.addUser(user1);
        documentManager.addUser(user2);
        webSocketServer.addUser(user1);
        webSocketServer.addUser(user2);

        // Simulate editing
        user1.editDocument("User 1 is editing...");
        user2.editDocument("User 2 is editing...");
    }
}