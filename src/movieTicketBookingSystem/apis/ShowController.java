package movieTicketBookingSystem.apis;

import movieTicketBookingSystem.model.Movie;
import movieTicketBookingSystem.model.Screen;
import movieTicketBookingSystem.model.Seat;
import movieTicketBookingSystem.model.Show;
import movieTicketBookingSystem.services.MovieService;
import movieTicketBookingSystem.services.SeatAvailabilityService;
import movieTicketBookingSystem.services.ShowService;
import movieTicketBookingSystem.services.TheatreService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
     ShowController
        - create show API (movie, screen should pre-exist)
        - get available seats API for a show
*/
// todo: extend show from movie ticket booking to any kind of show

public class ShowController {
    private final TheatreService theatreService;
    private final MovieService movieService;
    private final ShowService showService;
    private final SeatAvailabilityService seatAvailabilityService;

    public ShowController(TheatreService theatreService, MovieService movieService, ShowService showService, SeatAvailabilityService seatAvailabilityService) {
        this.theatreService = theatreService;
        this.movieService = movieService;
        this.showService = showService;
        this.seatAvailabilityService = seatAvailabilityService;
    }

    public String createShow(final String movieId, final String screenId, final Date startTime,
                             final Integer durationInSeconds) {
        final Screen screen = theatreService.getScreen(screenId);
        final Movie movie = movieService.getMovie(movieId);
        return showService.createShow(movie, screen, startTime, durationInSeconds).get().getId();
    }

    public List<String> getAvailableSeatsForShow(final String showId) {
        Show show = showService.getShow(showId);
        // check seat availability
        final List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        List<String> res = new ArrayList<>();
        for(Seat seat: availableSeats) {
            res.add(seat.getId());
        }
        return res;
    }
}
