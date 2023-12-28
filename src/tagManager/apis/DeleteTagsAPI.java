package tagManager.apis;

import tagManager.cmd.Command;
import tagManager.cmd.CommandFactory;
import tagManager.data.IStoreImpl;
import tagManager.data.MatchType;
import tagManager.rcv.PartialMatchDeleter;
import tagManager.rcv.PerfectMatchDeleter;
import tagManager.rcv.TagInserter;
import tagManager.tag.TagManager;

import java.util.regex.Pattern;

/*
    Here we have to own the creational responsibility of all type of Command
    So, we can use Factory pattern for centralising this responsibility
*/
public class DeleteTagsAPI {
    public void deleteTags(String name, MatchType matchType) {
        Command command = null;
        if (matchType.equals(MatchType.PERFECT)) {
            command = CommandFactory.getPerfectMatchDeleteCmd(name, new PerfectMatchDeleter(new IStoreImpl()), new TagInserter());
        } else if (matchType.equals(MatchType.PARTIAL)) {
            command = CommandFactory.getPartialMatchDeleteCmd(Pattern.compile(name), new PartialMatchDeleter());
        } else {
            throw new IllegalArgumentException("invalid match type");
        }

        TagManager tagManager = new TagManager();
        tagManager.changeTags(command); // -> changeTags for this command -> relevant execute method called
        tagManager.undo(); // -> calls undo on the same stack
    }
}
