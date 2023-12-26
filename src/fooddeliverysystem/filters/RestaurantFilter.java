package fooddeliverysystem.filters;

import fooddeliverysystem.data.Restaurant;

public interface RestaurantFilter {
    boolean filter(Restaurant restaurant);
}
