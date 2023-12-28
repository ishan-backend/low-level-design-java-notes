package tagManager.rcv;
import tagManager.data.Store;

public class TagInserter {
    public void insert(String tagName){
        Store.insertTag(tagName);
    }
}
