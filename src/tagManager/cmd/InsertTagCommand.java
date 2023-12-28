package tagManager.cmd;

import tagManager.rcv.PerfectMatchDeleter;
import tagManager.rcv.TagInserter;

public class InsertTagCommand implements Command {
    private final String newTagName;
    private final TagInserter tagInserter;

    // to support undo operation for insert
    private final PerfectMatchDeleter perfectMatchDeleter;

    public InsertTagCommand(String newTagName, TagInserter tagInserter, PerfectMatchDeleter perfectMatchDeleter) {
        this.newTagName = newTagName;
        this.tagInserter = tagInserter;
        this.perfectMatchDeleter = perfectMatchDeleter;
    }

    @Override
    public void execute() {
        this.tagInserter.insert(this.newTagName);
    }

    @Override
    public void undo() {
        this.perfectMatchDeleter.delete(newTagName);
    }
}
