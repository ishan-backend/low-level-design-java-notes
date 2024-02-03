package movieTicketBookingSystem.services;

import movieTicketBookingSystem.exceptions.BadRequestException;
import movieTicketBookingSystem.exceptions.NotFoundException;
import movieTicketBookingSystem.exceptions.SeatPermanentlyUnavailableException;
import movieTicketBookingSystem.model.Booking;
import movieTicketBookingSystem.model.Seat;
import movieTicketBookingSystem.model.Show;
import movieTicketBookingSystem.providers.ISeatLockProvider;

import java.util.*;

/*
    Booking schema :-
    booking_id -> booking details (show FK, list<seats> FK, user)

*/
public class BookingService {
    private final Map<String, Booking> bookings;
    private final ISeatLockProvider seatLockProvider;


    public BookingService(ISeatLockProvider seatLockProvider) {
        this.bookings = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    public List<Booking> getAllBookingsForAShow(final Show show) {
        List<Booking> resp = new ArrayList<>();
        for(Booking booking: bookings.values()) {
            if(booking.getShow().equals(show)) {
                resp.add(booking);
            }
        }

        return resp;
    }

    public List<Seat> getAllConfirmedSeatsForAShow(final Show show) { // todo: VVIP stream() and filter() if booking is in confirmed state,
       // return getAllBookingsForAShow(show).stream().filter(Booking::isConfirmed).map(Booking::getSeatsBooked).flatMap(Collection::stream).collect(Collectors.toList());
        List<Booking> allBookings = getAllBookingsForAShow(show);

        List<Seat> confirmedSeats = new ArrayList<>();
        for (Booking booking : allBookings) {
            if (booking.isConfirmed()) {
                confirmedSeats.addAll(booking.getSeatsBooked());
            }
        }

        return confirmedSeats;
    }

    public Booking getBooking(final String bookingId) {
        if (!bookings.containsKey(bookingId)) {
            throw new NotFoundException();
        }
        return bookings.get(bookingId);
    }

    // createBooking creates a booking for few seats in a show with a expiry time setter
    // todo: update booking flow with expiry time
    public Booking createBooking(final String userId, final Show show, final List<Seat> seats) {
        if(isAnySeatAlreadyConfirmedBooked(show, seats)) {
            throw new SeatPermanentlyUnavailableException();
        }

        seatLockProvider.lockSeats(show, seats, userId);
        final String bookingId = UUID.randomUUID().toString();
        final Booking booking = new Booking(bookingId, show, seats, userId);
        bookings.put(bookingId, booking);
        return booking;
    }

    // confirmBooking is called when payment is completed from controller
    // if someone later creates a booking
    public void confirmBooking(final Booking booking, final String userId) {
        for(Seat seat: booking.getSeatsBooked()) {
            if(!seatLockProvider.validateLock(booking.getShow(), seat, userId)) { // matching payment made by userId for a booking is equivalent to locked userId
                throw new BadRequestException();
            }
        }
        booking.confirmBooking();
    }

    // helpers
    private boolean isAnySeatAlreadyConfirmedBooked(final Show show, final List<Seat> seats){
        final List<Seat> confirmedSeats = getAllConfirmedSeatsForAShow(show);
        for (Seat seat : seats) {
            if (confirmedSeats.contains(seat)) {
                return true;
            }
        }
        return false;
    }

    // getters

}
