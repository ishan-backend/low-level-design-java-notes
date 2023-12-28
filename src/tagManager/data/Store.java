package tagManager.data;

import java.util.ArrayList;
import java.util.List;

/*
    Store class mocks the DB level methods available at mySQL level
        - A class which contains list of strings (tags) which exposes some get and insert, etc. methods
        - This is needed for our actual deleter implementations inside receiver
*/
public class Store {
    public static List<String> tags = new ArrayList<String>()
    {
        {
            add("knapsack");
            add("maths");
            add("mathematics");
            add("sieve");
            add("runtime error");
        }
    };

    public static List<String> getTags() {
        return tags;
    }

    public static void delete(String tagName) {
        System.out.println("tag deleted: "+ tagName);
        tags.remove(tagName);
    }

    public static void insertTag(String tagName) {
        System.out.println("tag added: "+ tagName);
        tags.add(tagName);
    }
}
