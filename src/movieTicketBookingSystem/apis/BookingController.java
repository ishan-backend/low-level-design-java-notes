package movieTicketBookingSystem.apis;

import movieTicketBookingSystem.model.Seat;
import movieTicketBookingSystem.model.Show;
import movieTicketBookingSystem.services.BookingService;
import movieTicketBookingSystem.services.ShowService;
import movieTicketBookingSystem.services.TheatreService;

import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private final TheatreService theatreService;
    private final ShowService showService;
    private final BookingService bookingService;

    public BookingController(TheatreService theatreService, ShowService showService, BookingService bookingService) {
        this.theatreService = theatreService;
        this.showService = showService;
        this.bookingService = bookingService;
    }

    public String createBooking(final String userId, final String showId, final List<String> seatsIds) {
        final Show show = showService.getShow(showId);
        List<Seat> seats = new ArrayList<>();
        for(String seatId: seatsIds) {
            Seat seat = theatreService.getSeat(seatId);
            seats.add(seat);
        }

        return bookingService.createBooking(userId, show, seats).getId();
    }
}