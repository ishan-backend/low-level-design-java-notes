package fooddeliverysystem.api;

import fooddeliverysystem.data.*;
import fooddeliverysystem.filters.CuisineTypeFilter;
import fooddeliverysystem.filters.MealTypeFilter;
import fooddeliverysystem.filters.RestaurantFilter;
import fooddeliverysystem.filters.StarRatingFilter;
import fooddeliverysystem.searchers.RestaurantSearcher;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcherAPI {
    public List<Restaurant> searchRestaurants(String restaurantName, MealType mealType, List<CuisineType> cuisines, StarRating rating) {
        // todo: validations
        List<RestaurantFilter> filters = new ArrayList<>();
        if(mealType != null) {
            filters.add(new MealTypeFilter(mealType));
        }
        if(cuisines != null) {
            filters.add(new CuisineTypeFilter(cuisines));
        }
        if(rating != null) {
            filters.add(new StarRatingFilter(rating));
        }
        return new RestaurantSearcher().search(restaurantName, filters);

        // todo: use factory design pattern to avoid new new new, concrete Classes directly, delay it using the same.
    }
}
