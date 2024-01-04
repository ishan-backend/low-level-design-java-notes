package parkingLot.vehicleManager;

import parkingLot.data.VehicleType;

public class VehicleTypeManagerFactory {
    private VehicleTypeManagerFactory(){}
    public static IVehicleTypeManager getVehicleTypeManager(VehicleType vehicleType) {
        IVehicleTypeManager vehicleTypeManager = null;
        if(vehicleType.equals(VehicleType.TWO_WHEELER)) {
            vehicleTypeManager = new TwoWheelerManager();
        }

        return vehicleTypeManager;
    }
}
