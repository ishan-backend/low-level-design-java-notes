package fooddeliverysystem.searchers;

import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.filters.FoodItemFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcher { // this code will follow OCP, on adding new filter nothing needs to be changed
    public List<FoodItem> search(String foodItemName, List<FoodItemFilter> filters) {
        // validation at top layer
        if(foodItemName == null || foodItemName.length() == 0 || filters == null) {
            throw  new IllegalArgumentException("Missing params");
        }
        // low level db call to get results
        DataAccessResult dataAccessResult = DataAccessor.getFoodItemsWithName(foodItemName);
        // parse the db result to food items list
        List<FoodItem> foodItems = DataAccessObjectConvertor.convertToFoodItems(dataAccessResult);

        // now you can pass it to other business classes, since they know about foodItems and not dataAccessResult
        for(FoodItemFilter filter : filters) {
            List<FoodItem> filteredFoodItems = new ArrayList<>();
            for(FoodItem foodItem: foodItems) {
                if(filter.filter(foodItem)) {
                    filteredFoodItems.add(foodItem);
                }
            }
            foodItems = filteredFoodItems; // apply filters only on the result of last filter applied
        }

        return foodItems;
    }
}
