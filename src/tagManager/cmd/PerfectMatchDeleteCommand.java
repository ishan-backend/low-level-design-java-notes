package tagManager.cmd;

/*
    Inside all the concrete implementations of command interface
    there will be execute() method implementation
    this execute() method should have very simple body (2-3 lines), since actual work of execute will be composed of multiple steps
        "since all the implementation code logic will be very bulky, we should delegate it"
        we will use "receiver" - an object of some other class, which actually knows and contains logic deletion based on exact logic
*/

import tagManager.rcv.PerfectMatchDeleter;
import tagManager.rcv.TagInserter;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleteCommand implements Command{

    // constructor injection on parameter on which execute will work
    private final String tagName;
    private final PerfectMatchDeleter perfectMatchDeleter;

    // to support undo() operations we need InsertTag Receiver concrete implementation
    private final TagInserter tagInserter;
    private final List<String> deletedTags;
    public PerfectMatchDeleteCommand(String name, PerfectMatchDeleter perfectMatchDeleter, TagInserter tagInserter) {
        this.tagName = name;
        this.perfectMatchDeleter = perfectMatchDeleter;
        this.tagInserter = tagInserter;
        this.deletedTags = new ArrayList<>();
    }

    @Override
    public void execute() {
        // delegates work to receiver deleter, and adds responses to deletedTags
        this.deletedTags.addAll(this.perfectMatchDeleter.delete(this.tagName));
    }

    @Override
    public void undo() {
        for(String tag: deletedTags) {
            tagInserter.insert(tag);
        }
        this.deletedTags.clear();
    }
}
