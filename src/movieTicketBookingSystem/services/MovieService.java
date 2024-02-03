package movieTicketBookingSystem.services;

import com.sun.istack.internal.NotNull;
import movieTicketBookingSystem.exceptions.NotFoundException;
import movieTicketBookingSystem.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {
    private final Map<String, Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    public Movie createMovie(@NotNull final String movieName) {
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId, movieName);
        movies.put(movieId, movie);
        return movie;
    }

    // getter
    public Movie getMovie(@NotNull final String movieId) {
        if (!movies.containsKey(movieId)) {
            throw new NotFoundException();
        }
        return movies.get(movieId);
    }
}
