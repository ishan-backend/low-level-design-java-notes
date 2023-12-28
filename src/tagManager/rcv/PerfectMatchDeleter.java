package tagManager.rcv;

import tagManager.data.IStore;
import tagManager.data.Store;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleter {
    private final IStore iStore;

    public PerfectMatchDeleter(IStore iStore) {
        this.iStore = iStore;
    }

    public List<String> delete(String tagName) { // returns List<String> to support undo operations
        if (tagName == null || tagName.length()  == 0)
            throw new IllegalArgumentException();

        // we have mocked the DB connection using data/Store class
        // collect into new list
        List<String> dbTags = new ArrayList<>();
        iStore.getTags().forEach(tag -> dbTags.add(tag));

        List<String> deletedTags = new ArrayList<>();
        // if name matches tag, delete it
        for(String tag: dbTags) {
            if(tag.equals(tagName)) {
                iStore.delete(tag);
                deletedTags.add(tag);
            }
        }

        return deletedTags;
    }
}
