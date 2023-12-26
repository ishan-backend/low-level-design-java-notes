package fooddeliverysystem.filters;

import fooddeliverysystem.data.CuisineType;
import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.Restaurant;

import java.util.List;

public class CuisineTypeFilter implements FoodItemFilter, RestaurantFilter {
    private final List<CuisineType> cuisineTypes;

    public CuisineTypeFilter(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return cuisineTypes.contains(foodItem.getCuisineType());
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        List<CuisineType> cuisines = restaurant.getCuisineTypes();
        for(CuisineType cuisineType : cuisineTypes) {
            if(cuisines.contains(cuisineType)) {
                return true;
            }
        }
        return false;
    }
}
