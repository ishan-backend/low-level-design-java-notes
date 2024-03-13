package googleDocs;

public interface AccessControl {
    boolean hasPermission(User user, String permission);
}
