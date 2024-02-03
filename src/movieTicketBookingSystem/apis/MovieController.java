package movieTicketBookingSystem.apis;

import movieTicketBookingSystem.services.MovieService;

public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String createMovie(final String movieName) {
        return movieService.createMovie(movieName).getId();
    }
}
