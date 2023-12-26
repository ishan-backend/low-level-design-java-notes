package fooddeliverysystem.data;

import java.util.List;

public class Restaurant {
    private final int id;
    private final int name;
    private final int description;
    private final BusinessHours businessHours;
    private final MealType mealType;
    private final List<CuisineType> cuisineTypes;
    private final StarRating starRating;
    private final Menu menu;

    public Restaurant(int id, int name, int description, BusinessHours businessHours, MealType mealType, List<CuisineType> cuisineTypes, StarRating starRating, Menu menu) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.businessHours = businessHours;
        this.mealType = mealType;
        this.cuisineTypes = cuisineTypes;
        this.starRating = starRating;
        this.menu = menu;
    }
    // todo: add builder pattern

    // data classes need getters
    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }

    public MealType getMealType() {
        return mealType;
    }

    public List<CuisineType> getCuisineTypes() {
        return cuisineTypes;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public Menu getMenu() {
        return menu;
    }

}
