package tagManager.cmd;

import tagManager.rcv.PartialMatchDeleter;
import tagManager.rcv.PerfectMatchDeleter;
import tagManager.rcv.TagInserter;

import java.util.regex.Pattern;

public class CommandFactory {
    // private constructors for all factories
    private CommandFactory() {}

    public static Command getPartialMatchDeleteCmd(
            Pattern pattern,
            PartialMatchDeleter partialMatchDeleter
    ) {
        return new PartialMatchDeleteCommand(pattern, partialMatchDeleter);
    }

    public static Command getPerfectMatchDeleteCmd(
            String tag,
            PerfectMatchDeleter perfectMatchDeleter,
            TagInserter tagInserter
    ) {
        return new PerfectMatchDeleteCommand(tag, perfectMatchDeleter, tagInserter);
    }

    public static Command getInsertTagCmd(
            String newTagName,
            TagInserter tagInserter,
            PerfectMatchDeleter perfectMatchDeleter
    ) {
        return new InsertTagCommand(newTagName, tagInserter, perfectMatchDeleter);
    }
}
