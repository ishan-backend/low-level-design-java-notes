package parkingLot.data;

import java.time.LocalDateTime;

public class Vehicle {
    private final String numberPlate;
    private final VehicleType vehicleType;
    private final String modelName;
    private final LocalDateTime entryTime;

    public Vehicle(String numberPlate, VehicleType vehicleType, String modelName, LocalDateTime entryTime) {
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
        this.modelName = modelName;
        this.entryTime = entryTime;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public String getModelName() {
        return modelName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }
}
