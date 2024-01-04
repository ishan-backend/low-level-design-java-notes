package parkingLot.apis;

import parkingLot.data.ParkingSpot;
import parkingLot.vacator.ParkingSpotVacator;

public class VacateParkingSpotAPI {
    public void vacateParkingSpot(ParkingSpot parkingSpot) {
        // marks it as free in DB
        // underlying class - ParkingSpotVacator

        // check if user is Admin or not, post that allow him to vacate it. Discussed in Lib Mgmt system
        new ParkingSpotVacator().vacateParkingSpot(parkingSpot);
    }
}
