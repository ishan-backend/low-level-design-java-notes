package movieTicketBookingSystem.providers;

import movieTicketBookingSystem.model.Seat;
import movieTicketBookingSystem.model.Show;

import java.util.List;

// ISeatLockProvider is used by SeatAvailability service
public interface ISeatLockProvider {
    // if you are booking seats for a show, you may select/unselect as well
    void lockSeats(Show show, List<Seat> seats, String user);
    void unlockSeats(Show show, List<Seat> seats, String user);

    // you may lock/unlock, but before making payment validate once
    boolean validateLock(Show show, Seat seat, String user);

    // for app to show available seats, it would need unavailable seats as well
    List<Seat> getLockedSeats(Show show);
}
