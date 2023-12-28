package tagManager.rcv;

import tagManager.data.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PartialMatchDeleter {
    public void delete(Pattern regex) {
        List<String> dbTags = new ArrayList<>();
        Store.getTags().forEach(tag -> dbTags.add(tag));

        // if partial name matches tag, delete it
        for(String tag: dbTags) {
            if(regex.matcher(tag).matches()) {
                Store.delete(tag);
            }
        }
    }
}
