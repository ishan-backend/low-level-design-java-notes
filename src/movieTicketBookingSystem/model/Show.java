package movieTicketBookingSystem.model;

import java.util.Date;


/*
    Shows table:
    id,
    startTime,
    DurationInsecs,
    Movie FK
    Screen FK

    1 Movie can be in n Show
    1 Screen can be in n Show
    Show is downstream system
*/
public class Show {
    private final String id;
    private final Movie movie;
    private final Screen screen;
    private final Date startTime;
    private final Integer durationInSeconds;

    public Show(String id, Movie movie, Screen screen, Date startTime, Integer durationInSeconds) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.durationInSeconds = durationInSeconds;
    }

    // getters

    public Screen getScreen() {
        return screen;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getId() {
        return id;
    }
}
