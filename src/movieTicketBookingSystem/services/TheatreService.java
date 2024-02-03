package movieTicketBookingSystem.services;

import com.sun.istack.internal.NotNull;
import movieTicketBookingSystem.exceptions.NotFoundException;
import movieTicketBookingSystem.model.Screen;
import movieTicketBookingSystem.model.Seat;
import movieTicketBookingSystem.model.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/*
    Theatre schema:
        theatres table: id, name
        theatres:screens: 1:n mapping, screens will have a FK to theatres
        screens:seats: 1:n mapping, seats will have a FK to screens
*/
public class TheatreService{
    private final Map<String, Theatre> theatres; // theatre_id -> Theatre
    private final Map<String, Screen> screens; // theatre_id -> Screen
    private final Map<String, Seat> seats; // seat_id -> Seat, Screen has a list<Seat>

    public TheatreService() {
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
    }

    public Theatre createTheatre(@NotNull final String theatreName) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, theatreName); // create data model / DAO object
        theatres.put(theatreId, theatre); // save into db/in-memory
        return theatre;
    }

    public Screen createScreenInTheatre(@NotNull final String screenName, @NotNull final Theatre theatre) {
        Screen screen = createScreen(screenName, theatre);
        theatre.addScreen(screen);
        return screen;
    }

    public Seat createSeatInScreen(@NotNull final Integer rowNo, @NotNull final Integer seatNo, @NotNull final Screen screen) {
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId, rowNo, seatNo);
        seats.put(seatId, seat); // add seatId and details in seats table

        screen.addSeat(seat); // add FK to
        return seat;
    }

    // internal helper methods
    private Screen createScreen(final String screenName, final Theatre theatre) {
        String screenId = UUID.randomUUID().toString();
        Screen screen = new Screen(screenId, screenName, theatre);
        screens.put(screenId, screen);
        return screen;
    }

    // getters

    public Theatre getTheatre(@NotNull final String theatreId) {
        if (!theatres.containsKey(theatreId)) {
            throw new NotFoundException();
        }
        return theatres.get(theatreId);
    }

    public Screen getScreen(@NotNull final String screenId) {
        if (!screens.containsKey(screenId)) {
            throw new NotFoundException();
        }
        return screens.get(screenId);
    }

    public Seat getSeat(@NotNull final String seatId) {
        if (!seats.containsKey(seatId)) {
            throw new NotFoundException();
        }
        return seats.get(seatId);
    }
}
