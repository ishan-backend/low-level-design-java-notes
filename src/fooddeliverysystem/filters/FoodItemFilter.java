package fooddeliverysystem.filters;

import fooddeliverysystem.data.FoodItem;

public interface FoodItemFilter {
    boolean filter(FoodItem foodItem);
}
