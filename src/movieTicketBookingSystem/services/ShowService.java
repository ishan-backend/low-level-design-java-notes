package movieTicketBookingSystem.services;

import movieTicketBookingSystem.model.Movie;
import movieTicketBookingSystem.model.Screen;
import movieTicketBookingSystem.model.Show;

import java.util.*;

public class ShowService {
    private final Map<String, Show> shows;

    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Optional<Show> createShow(final Movie movie, final Screen screen, final Date dateTime, final Integer durationInSeconds) {
        if(checkIfShowCreationAllowed(screen, dateTime, durationInSeconds)) {
            String showId = UUID.randomUUID().toString();
            Show show = new Show(showId, movie, screen, dateTime, durationInSeconds);
            shows.put(showId, show);
            return Optional.of(show);
        }
        return Optional.empty();
    }

    public List<Show> getShowsForScreen(final Screen screen) {
        final List<Show> response = new ArrayList<>();
        for (Show show : shows.values()) {
            if (show.getScreen().equals(screen)) {
                response.add(show);
            }
        }
        return response;
    }

    private boolean checkIfShowCreationAllowed(final Screen screen, final Date startTime, final Integer durationInSeconds) {
        // TODO: Implement this. This method will return whether the screen is free at a particular time for
        // specific duration. This function will be helpful in checking whether the show can be scheduled in that slot
        // or not.
        return true;
    }

    // getters
    public Show getShow(final String showId) {
        return shows.get(showId);
    }
}
