package tagManager.apis;

import tagManager.cmd.Command;
import tagManager.cmd.CommandFactory;
import tagManager.data.IStoreImpl;
import tagManager.rcv.PerfectMatchDeleter;
import tagManager.rcv.TagInserter;
import tagManager.tag.TagManager;

public class InsertTagAPI {
    public void insertTag(String name) {
        Command command = null;
        if (name.length() == 0) {
            throw new IllegalArgumentException("invalid tag name");
        }
        command = CommandFactory.getInsertTagCmd(name, new TagInserter(), new PerfectMatchDeleter(new IStoreImpl()));

        TagManager tagManager = new TagManager();
        tagManager.changeTags(command); // -> changeTags for this command -> relevant execute method called
        tagManager.undo();
    }
}
