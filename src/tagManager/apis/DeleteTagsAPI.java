package tagManager.apis;

import tagManager.cmd.Command;
import tagManager.cmd.CommandFactory;
import tagManager.data.MatchType;
import tagManager.rcv.PartialMatchDeleter;
import tagManager.rcv.PerfectMatchDeleter;
import tagManager.tag.TagManager;

import java.util.regex.Pattern;

/*
    Here we have to own the creational responsibility of all type of Command
    So, we can use Factory pattern for centralising those responsibility
*/
public class DeleteTagsAPI {
    public void deleteTags(String name, MatchType matchType) {
        Command command = null;
        if (matchType.equals(MatchType.PERFECT)) {
            command = CommandFactory.getPerfectMatchDeleteCmd(name, new PerfectMatchDeleter());
        } else if (matchType.equals(MatchType.PARTIAL)) {
            command = CommandFactory.getPartialMatchDeleteCmd(Pattern.compile(name), new PartialMatchDeleter());
        } else {
            throw new IllegalArgumentException("invalid match type");
        }

        new TagManager(command).changeTags(); // -> changeTags for this command -> relevant execute method called
    }
}
