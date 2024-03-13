package googleDocs;

public abstract class User {
    protected String id;
    protected Document document;
    protected WebSocketServer server;

    public User(String id, Document document, WebSocketServer server) {
        this.id = id;
        this.document = document;
        this.server = server;
    }

    public String getId() {
        return id;
    }

    public abstract void editDocument(String newText);
    public abstract void receiveDocumentUpdate(String newText);
}
