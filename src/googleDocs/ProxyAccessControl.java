package googleDocs;

import java.util.*;

public class ProxyAccessControl implements AccessControl{
    private Map<User, List<String>> permissions;

    public ProxyAccessControl() {
        permissions = new HashMap<>();
    }

    public void grantPermission(User user, String permission) {
        permissions.computeIfAbsent(user, k -> new ArrayList<>()).add(permission);
    }

    @Override
    public boolean hasPermission(User user, String permission) {
        return permissions.getOrDefault(user, Collections.emptyList()).contains(permission);
    }


}
