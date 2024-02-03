package movieTicketBookingSystem.providers;

import movieTicketBookingSystem.exceptions.SeatTemporaryUnavailableException;
import movieTicketBookingSystem.model.Seat;
import movieTicketBookingSystem.model.SeatLock;
import movieTicketBookingSystem.model.Show;

import java.util.*;

public class InMemorySeatLockProvider implements ISeatLockProvider{
    private final Integer constLockTimeout;
    private final Map<Show, Map<Seat, SeatLock>> inMemoryLocks;

    public InMemorySeatLockProvider(Integer constLockTimeout) {
        this.constLockTimeout = constLockTimeout;
        this.inMemoryLocks = new HashMap<>();
    }

    @Override
    synchronized public void lockSeats(Show show, List<Seat> seats, String user) {
        // check if seat is locked by some other user, then revert with exception
        for(Seat seat: seats) {
            if(isSeatLocked(show, seat)) {
                throw new SeatTemporaryUnavailableException();
            }
        }

        for(Seat seat: seats) {
            lockSeat(show, seat, user, constLockTimeout);
        }
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, String user) {
        for (Seat seat: seats) {
            if (validateLock(show, seat, user)) { // business logic
                unlockSeat(show, seat); // internal unlocking
            }
        }
    }

    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        // is this seat locked and if so, locked by this user only
        return isSeatLocked(show, seat) && inMemoryLocks.get(show).get(seat).getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) { // returned list of locked seats should be immutable
        final List<Seat> lockedSeats = new ArrayList<>();
        if (!inMemoryLocks.containsKey(show)) {
            return lockedSeats;
        }

        for (Seat seat : inMemoryLocks.get(show).keySet()) { // internal map ka key dekhne ke liye
            if (isSeatLocked(show, seat)) {
                lockedSeats.add(seat);
            }
        }
        return lockedSeats;
    }

    // helper methods and getters
    private boolean isSeatLocked(final Show show, final Seat seat) {
        return inMemoryLocks.containsKey(show) && inMemoryLocks.get(show).containsKey(seat) && !inMemoryLocks.get(show).get(seat).isLockExpired();
    }

    private void lockSeat(final Show show, final Seat seat, final String user, final Integer timeoutInSeconds) {
        if(!inMemoryLocks.containsKey(show)) { // if first time seat is getting locked, then in memory lock wont have show instance
            inMemoryLocks.put(show, new HashMap<>());
        }

        // create and save seat lock entity in-memory
        final SeatLock seatLock = new SeatLock(seat, show, timeoutInSeconds, new Date(), user);
        inMemoryLocks.get(show).put(seat, seatLock);
    }

    private void unlockSeat(final Show show, final Seat seat) {
        if (!inMemoryLocks.containsKey(show)) {
            return;
        }
        inMemoryLocks.get(show).remove(seat);
    }
}
