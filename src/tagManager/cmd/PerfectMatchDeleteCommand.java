package tagManager.cmd;

/*
    Inside all the concrete implementations of command interface
    there will be execute() method implementation
    this execute() method should have very simple body (2-3 lines), since actual work of execute will be composed of multiple steps
        "since all the implementation code logic will be very bulky, we should delegate it"
        we will use "receiver" - an object of some other class, which actually knows and contains logic deletion based on exact logic
*/

import tagManager.rcv.PerfectMatchDeleter;

public class PerfectMatchDeleteCommand implements Command{

    // constructor injection on parameter on which execute will work
    private final String tagName;
    private final PerfectMatchDeleter perfectMatchDeleter;
    public PerfectMatchDeleteCommand(String name, PerfectMatchDeleter perfectMatchDeleter) {
        this.tagName = name;
        this.perfectMatchDeleter = perfectMatchDeleter;
    }

    @Override
    public void execute() {
        // delegates work to receiver deleter
        this.perfectMatchDeleter.delete(tagName);
    }
}
