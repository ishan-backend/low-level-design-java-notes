package tagManager.cmd;

import tagManager.rcv.PartialMatchDeleter;
import tagManager.rcv.PerfectMatchDeleter;

import java.util.regex.Pattern;

public class PartialMatchDeleteCommand implements Command{
    private final Pattern regex;
    private final PartialMatchDeleter partialMatchDeleter;
    public PartialMatchDeleteCommand(Pattern regex, PartialMatchDeleter partialMatchDeleter) {
        this.regex = regex;
        this.partialMatchDeleter = partialMatchDeleter;
    }
    @Override
    public void execute() {
        this.partialMatchDeleter.delete(this.regex);
    }
}
