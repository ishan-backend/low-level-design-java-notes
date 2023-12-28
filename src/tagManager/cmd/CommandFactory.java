package tagManager.cmd;

import tagManager.rcv.PartialMatchDeleter;
import tagManager.rcv.PerfectMatchDeleter;

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
            PerfectMatchDeleter perfectMatchDeleter
    ) {
        return new PerfectMatchDeleteCommand(tag, perfectMatchDeleter);
    }
}
