package movieTicketBookingSystem.services;

import movieTicketBookingSystem.model.Seat;
import movieTicketBookingSystem.model.Show;
import movieTicketBookingSystem.providers.ISeatLockProvider;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {
    private final BookingService bookingService;
    private final ISeatLockProvider seatLockProvider;

    public SeatAvailabilityService(final BookingService bookingService, final ISeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(final Show show) {
        final List<Seat> allSeats = show.getScreen().getSeats();
        final List<Seat> unavailableSeats = getUnavailableSeats(show);

        final List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(unavailableSeats);
        return availableSeats;
    }

    private List<Seat> getUnavailableSeats(final Show show) {
        final List<Seat> unavailableSeats = bookingService.getAllConfirmedSeatsForAShow(show);
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats;
    }
}
