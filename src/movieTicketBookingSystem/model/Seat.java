package movieTicketBookingSystem.model;

public class Seat {
    private final String id;
    private final int rowNo;
    private final int seatNo;

    public Seat(String id, int rowNo, int seatNo) {
        this.id = id;
        this.rowNo = rowNo;
        this.seatNo = seatNo;
    }

    public String getId() {
        return id;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public int getRowNo() {
        return rowNo;
    }
}
