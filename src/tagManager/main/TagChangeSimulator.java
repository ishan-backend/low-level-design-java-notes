package tagManager.main;

import tagManager.apis.DeleteTagsAPI;
import tagManager.data.MatchType;

/*
    To run navigate to tagManager class and run the following commands:
        find . -name "*.java" > sources.txt
        javac -sourcepath . @sources.txt
*/
public class TagChangeSimulator {
    public static void main(String[] args){
        new DeleteTagsAPI().deleteTags("math.*", MatchType.PARTIAL);
    }
}
