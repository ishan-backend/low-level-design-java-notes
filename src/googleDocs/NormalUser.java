package googleDocs;

public class NormalUser extends User {
    public NormalUser(String id, Document document, WebSocketServer server) {
        super(id, document, server);
    }

    @Override
    public void editDocument(String newText) {
        if (document != null) {
            document.setContent(newText);
            server.notifyAllUsers(this, newText);
        }
    }
    @Override
    public void receiveDocumentUpdate(String newText) {
        // Process received document update without triggering editing
        System.out.println("Received document update: " + newText);
    }

    }

