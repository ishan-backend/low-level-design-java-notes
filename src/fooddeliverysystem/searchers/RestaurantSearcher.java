package fooddeliverysystem.searchers;

import fooddeliverysystem.data.Restaurant;
import fooddeliverysystem.filters.RestaurantFilter;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcher {
    public List<Restaurant> search(String restaurantName, List<RestaurantFilter> filters) {
        // validation at top layer
        if(restaurantName == null || restaurantName.length() == 0 || filters == null) {
            throw  new IllegalArgumentException("Missing params");
        }
        // low level db call to get results
        DataAccessResult dataAccessResult = DataAccessor.getRestaurantsWithName(restaurantName);
        // parse the db result to food items list
        List<Restaurant> restaurants = DataAccessObjectConvertor.convertToRestaurants(dataAccessResult);

        // now you can pass it to other business classes, since they know about foodItems and not dataAccessResult
        for(RestaurantFilter filter : filters) {
            List<Restaurant> filteredRestaurants = new ArrayList<>();
            for(Restaurant r: restaurants) {
                if(filter.filter(r)) {
                    filteredRestaurants.add(r);
                }
            }
            restaurants = filteredRestaurants; // apply filters only on the result of last filter applied
        }

        return restaurants;
    }
}
}
