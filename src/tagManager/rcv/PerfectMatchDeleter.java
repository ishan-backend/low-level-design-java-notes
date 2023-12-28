package tagManager.rcv;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import tagManager.data.Store;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleter {
    public void delete(String tagName) {
        // we have mocked the DB connection using data/Store class
        // collect into new list
        List<String> dbTags = new ArrayList<>();
        Store.getTags().forEach(tag -> dbTags.add(tag));

        // if name matches tag, delete it
        for(String tag: dbTags) {
            if(tag.equals(tagName)) {
                Store.delete(tag);
            }
        }
    }
}
