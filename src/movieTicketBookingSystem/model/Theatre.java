package movieTicketBookingSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String id;
    private final String name;
    private final List<Screen> screens; // FK

    // other theatre metadata

    // constructor
    public Theatre(String id, String name) {
        this.id = id;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }

    // getters
    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getId() {
        return id;
    }
}
