package elevator.data;


/*
    In real-world, certain floors may be under construction, and hence not accessible.
    So we went ahead with Class instead of ENUMs
*/
public class Floor {
    private final int number;
    private final String name;
    // isSafe, etc

    public Floor(int number, String name) {
        this.number = number;
        this.name = name;
    }


    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
