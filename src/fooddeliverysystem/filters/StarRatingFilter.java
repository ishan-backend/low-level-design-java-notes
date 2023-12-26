package fooddeliverysystem.filters;

import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.Restaurant;
import fooddeliverysystem.data.StarRating;

public class StarRatingFilter implements FoodItemFilter, RestaurantFilter {
    private final StarRating rating;

    public StarRatingFilter(StarRating rating) {
        this.rating = rating;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getStarRating().getVal() >= rating.getVal();
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getStarRating().getVal() >= rating.getVal();
    }
}
