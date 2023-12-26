package fooddeliverysystem.api;

import fooddeliverysystem.data.CuisineType;
import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.MealType;
import fooddeliverysystem.data.StarRating;
import fooddeliverysystem.filters.*;
import fooddeliverysystem.searchers.FoodItemSearcher;
import fooddeliverysystem.searchers.RestaurantSearcher;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcherAPI { // API does not know of algorithm, for all such purposes it contacts searchers
    List<FoodItem> searchFoodItems(String foodItemName, MealType mealType, List<CuisineType> cuisines, StarRating rating) {
        List<FoodItemFilter> filters = new ArrayList<>();
        if(mealType != null) {
            filters.add(new MealTypeFilter(mealType));
        }
        if(cuisines != null) {
            filters.add(new CuisineTypeFilter(cuisines));
        }
        if(rating != null) {
            filters.add(new StarRatingFilter(rating));
        }
        return new FoodItemSearcher().search(foodItemName, filters);

        // todo: use factory design pattern to avoid new new new, concrete Classes directly, delay it using the same.
    }
}
