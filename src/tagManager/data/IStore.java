package tagManager.data;

import java.util.List;

public interface IStore {
    List<String> getTags();
    void delete(String tag);
    void insertTag(String tag);
}
