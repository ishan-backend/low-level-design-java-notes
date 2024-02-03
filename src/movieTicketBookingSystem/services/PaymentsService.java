package movieTicketBookingSystem.services;

import movieTicketBookingSystem.exceptions.BadRequestException;
import movieTicketBookingSystem.model.Booking;
import movieTicketBookingSystem.providers.ISeatLockProvider;

import java.util.HashMap;
import java.util.Map;

/*
    Additional functionality:

*/
public class PaymentsService {
    private final Integer allowedRetries; // as a constant for every API call
    private final ISeatLockProvider seatLockProvider; // provides unlock on seats, if payment fails, since locks were acquired when create booking API was hit
    Map<Booking, Integer> bookingFailures; // keeps current count of failed payment retries after which seats are unlocked


    public PaymentsService(Integer allowedRetries, ISeatLockProvider seatLockProvider) {
        this.allowedRetries = allowedRetries;
        this.seatLockProvider = seatLockProvider;
        bookingFailures = new HashMap<>();
    }

    public void processPaymentFailed(final Booking booking,final String userId) {
        if (!booking.getUserId().equals(userId)) { // extra safety check, wont happen in app
            throw new BadRequestException();
        }
        if (!bookingFailures.containsKey(booking)) {
            bookingFailures.put(booking, 0);
        }

        final Integer currentFailuresCount = bookingFailures.get(booking);
        final Integer newFailuresCount = currentFailuresCount + 1;
        bookingFailures.put(booking, newFailuresCount);

        if (newFailuresCount > allowedRetries) {
            seatLockProvider.unlockSeats(booking.getShow(), booking.getSeatsBooked(), booking.getUserId());
        } else {
            // todo: add some third party call, receive response via webhook and then this flow gets triggered again
        }
    }
}
