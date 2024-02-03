package movieTicketBookingSystem.model;

import movieTicketBookingSystem.exceptions.InvalidStateException;

import java.util.List;

public class Booking {
    private final String id;
    private final Show show;
    private final List<Seat> seatsBooked;
    private final String userId; // user can be a data class
    private BookingStatus bookingStatus;
    // other data , expiryAtTs
    // todo: payment flows and transaction id

    public Booking(String id, Show show, List<Seat> seatsBooked, String userId) { // to create booking
        this.id = id;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.userId = userId;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public boolean isConfirmed() {
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new InvalidStateException();
        }

        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) { // already in some destination state
            throw new InvalidStateException();
        }

        this.bookingStatus = BookingStatus.EXPIRED;
    }

    // getters
    public Show getShow() {
        return show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }
}
