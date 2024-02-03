package movieTicketBookingSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String id;
    private final String name;
    private final Theatre theatre;
    private final List<Seat> seats;
    // other screen metadata

    public Screen(String id, String name, Theatre theatre) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Theatre getTheatre() {
        return theatre;
    }
}
