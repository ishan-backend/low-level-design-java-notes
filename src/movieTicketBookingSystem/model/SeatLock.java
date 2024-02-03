package movieTicketBookingSystem.model;

import java.time.Instant;
import java.util.Date;

public class SeatLock {
    private Seat seat;
    private Show show;
    private Integer timeoutInSeconds;
    private Date lockedAt;
    private String lockedBy; // user name who locked

    public SeatLock(Seat seat, Show show, Integer timeoutInSeconds, Date lockedAt, String lockedBy) {
        this.seat = seat;
        this.show = show;
        this.timeoutInSeconds = timeoutInSeconds;
        this.lockedAt = lockedAt;
        this.lockedBy = lockedBy;
    }

    public boolean isLockExpired() {
        final Instant lockedTill = lockedAt.toInstant().plusSeconds(timeoutInSeconds);
        final Instant currTime = new Date().toInstant();
        return lockedTill.isBefore(currTime);
    }

    // getters
    public String getLockedBy() {
        return lockedBy;
    }
}
