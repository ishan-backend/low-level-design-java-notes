package movieTicketBookingSystem.apis;

import com.sun.istack.internal.NotNull;
import movieTicketBookingSystem.model.Screen;
import movieTicketBookingSystem.model.Theatre;
import movieTicketBookingSystem.services.TheatreService;

public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String createTheatre(@NotNull final String theatreName) {
        return this.theatreService.createTheatre(theatreName).getId();
    }

    public String createScreenInTheatre(@NotNull final String screenName, @NotNull final String theatreId) {
        final Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName, theatre).getId();
    }

    public String createSeatInScreen(@NotNull final Integer rowNo, @NotNull final Integer seatNo, @NotNull final String screenId) {
        final Screen screen = theatreService.getScreen(screenId);
        return theatreService.createSeatInScreen(rowNo, seatNo, screen).getId();
    }
}
