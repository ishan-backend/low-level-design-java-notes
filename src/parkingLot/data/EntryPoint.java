package parkingLot.data;

public class EntryPoint {
    private final String name;
    private final boolean isOpen;

    public EntryPoint(String name, boolean isOpen) {
        this.name = name;
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getName() {
        return name;
    }
}
