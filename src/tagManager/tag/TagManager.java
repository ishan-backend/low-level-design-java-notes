package tagManager.tag;

import tagManager.cmd.Command;
import java.util.Stack;

/*
    TagManager sits below API call, and API can choose to call whichever method of this class based on operation type
    TagManager class needs to follow OCP (Open Closed Principle), in the future, we need to add more operations, we need to add method to this class

    e.g.
        public class TagManager {
            // Create, Update, Delete
            public void insertTag(String tag){}
            public void deleteTag(String tag){}
            public void deleteBasedOnRegex(String name){}
            public void updateTag(String oldTag, String newTag){}

            // Read
            public List<String> getTags() {}
        }

    Solution 1: Make TagManager a polymorphic type, and write different implementations of TagManager class
        e.g. InsertionTagManager, DeletionTagManager, etc. but this won't make sense because,
        One thing to note:
            - create, update, delete variations can grow overtime, but Get operations will be fixed
        Good design:
            - Figure out which methods in a class are susceptible to grow overtime, and abstract them out in a polymorphic type (interface)
            - And then TagManager can depend on that polymorphic type
            e.g. polymorphic type - Command interface
                will have concrete implementations - Create, Update, Delete
                TagManager will only depend on Command

                This pattern is called Command Pattern. We identify it via the problem, if it requires multiple commands like in e.g. Calculator, etc.
                This is similar to Strategy pattern.
*/
public class TagManager {
    private final Stack<Command> commands; // to support undo we have used Stack

    public TagManager() {
        this.commands = new Stack<>();
    }

    // Tag manipulations (CUD) - whichever command is inserted to TagManager, it will call subsequent execute
    public void changeTags(Command command) {
        command.execute();
        this.commands.push(command);
    }

    public void undo() {
        if(commands.empty()) {
            throw new RuntimeException("No command to undo");
        }
        Command command = commands.peek();
        command.undo();
        commands.pop();
    }

    // Read, other methods
    // public List<String> getListOfTags() {}
}
