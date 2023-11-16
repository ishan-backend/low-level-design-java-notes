package fooddeliverysystem.api.data;

public enum StarRating {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    /*
      we want to support filter saying fetch rest/dishes with rating >= 3 of StarRating for which below constructor for enum is needed
    */

    private final int val;
    // constructor
    private StarRating(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }
}
