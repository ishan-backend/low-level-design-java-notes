package parkingLot.apis;

import parkingLot.data.EntryPoint;
import parkingLot.data.ParkingSpot;
import parkingLot.data.SpotSelectionStrategy;
import parkingLot.data.VehicleType;
import parkingLot.spotFinderStrategy.ParkingSpotFinder;
import parkingLot.spotManager.IParkingSpotSelectionManager;
import parkingLot.spotManager.SpotSelectorFactory;
import parkingLot.vehicleManager.IVehicleTypeManager;
import parkingLot.vehicleManager.VehicleTypeManagerFactory;

public class FindParkingSpotAPI {
    public ParkingSpot findParkingSpot(EntryPoint entryPoint, VehicleType vehicleType, SpotSelectionStrategy spotSelectionStrategy) {

        IVehicleTypeManager vehicleTypeManager = VehicleTypeManagerFactory.getVehicleTypeManager(vehicleType);
         /*
            if checks for spot selection strategy were inevitable because of arguments
            we need to delay it to as much top as possible, say API level is topmost
         */
        IParkingSpotSelectionManager spotSelectionManager;
        if(spotSelectionStrategy.equals(SpotSelectionStrategy.RANDOM)) {
            spotSelectionManager = SpotSelectorFactory.getRandomSpotSelector();
        } else if(spotSelectionStrategy.equals(SpotSelectionStrategy.NEAREST_FIRST)) {
            spotSelectionManager = SpotSelectorFactory.getNearestSpotSelector(entryPoint);
        } else {
            throw new IllegalArgumentException("invalid spot selection strategy");
        }

        /*
            Based on this,  vehicleTypeManager - we need to retrieve from DB, available parking spots
            Then using spotSelectionManager - we find the parking spot to park

            Logic of finding, and then selecting one - can be moved to another low level class i.e.
                which will need to contain reference to vehicleTypeManager, spotSelectionManager using injection via constructor

                -> Clear case of strategy pattern ...
        */
        return new ParkingSpotFinder(vehicleTypeManager, spotSelectionManager).findParkingSpot();
    }
}
