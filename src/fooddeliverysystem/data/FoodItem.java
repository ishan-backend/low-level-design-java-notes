package fooddeliverysystem.data;

public class FoodItem {
    private final int id; // from database
    private final int name;
    private final int description;
    private final double priceINR;
    private final MealType mealType;
    private final CuisineType cuisineType;
    private final StarRating starRating;
    private final boolean isAvailable;
    private final int restaurantId;

    public FoodItem(int id, int name, int description, double priceINR, MealType mealType, CuisineType cuisineType, StarRating starRating, boolean isAvailable, int restaurantId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceINR = priceINR;
        this.mealType = mealType;
        this.cuisineType = cuisineType;
        this.starRating = starRating;
        this.isAvailable = isAvailable;
        this.restaurantId = restaurantId;
    }
    // todo: using builder pattern you can reduce this big constructor
    // since certain fields can be optional which wont be needed while initialising an instance

    // getters of these important fields - put below constructor
    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public double getPriceINR() {
        return priceINR;
    }

    public MealType getMealType() {
        return mealType;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getRestaurantId() {
        return restaurantId;
    }
}
