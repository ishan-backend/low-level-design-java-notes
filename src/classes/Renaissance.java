package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Renaissance {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private final List<String> freeTrialModules = new ArrayList<String>();
    private final List<String> subscribedModules = new ArrayList<String>();

    public Renaissance() {
        freeTrialModules.add("Introduction");
        subscribedModules.add("Cleaning up files");
        subscribedModules.add("Design Patterns - Easy");
        subscribedModules.add("Design Patterns - Medium");
        subscribedModules.add("Design Patterns- Hard");
    }

    public Boolean isUserCredentialValid(String username, String password) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(username);
        if(!matcher.find()) {
            return false;
        }
        return isPresentInUsersTable(username, password);
    }

    private Boolean isPresentInUsersTable(String username, String password) {
        /*
        * Logic to query db
        * */
        return true;
    }

    public List<String> getModules(String username) {
        if(isPresentInSubscribersTable(username)) {
            return subscribedModules;
        }
        return freeTrialModules;
    }

    private Boolean isPresentInSubscribersTable(String username) {
        /*
         * Logic to query db
         * */
        return true;
    }

    public static void main(String []args) {
        String username = "ishan.backend@gmail.com", password = "12345";
        Renaissance renaissance = new Renaissance();
        if(renaissance.isUserCredentialValid(username, password)) {
            System.out.println(renaissance.getModules(username));
        } else {
            System.out.println("Invalid Credentials");
        }
    }
}
