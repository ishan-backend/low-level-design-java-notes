Food Delivery System - Requirements
1. Let’s Design a Food Delivery System Just like Zomato and Swiggy.

2. The first step is to gather requirements for our system.

3. In our system, users should be able to search for food items by their names. They should also be able to put some filters on the search like MealType i.e. Veg or Non Veg , Cuisine Type i.e. a Particular set of cuisines (Like Italian + German ).

4. For the fetched food items , users should be able to navigate to the corresponding restaurant , check the price-list and menu , add items to their cart and last but not least the user should be able to place an order.

5. Different Modes of Payment should be available i.e. NetBanking , CardBasedPayment etc.

6. A Cart can’t contain foodItems from multiple Restaurants.

7.User should be able to search for restaurants by their names.

8. Users should have the option to ADD or Remove FoodItems from their Cart.

9.The System should have important information about the User such as Delivery Address , Name , Phone Number to ensure the correct delivery.

10.User Should be able to Track order Status :

ORDER_PLACED ,

ORDER_PREPARING,

READY_FOR_DELIVERY ,

OUT_FOR_DELIVERYY,

ORDER_DELIVERED.

11. A User can also cancel the order if the cooking has not been started yet. That will change the order status as CANCELED.

12. The System should provide ETA for delivery.

13. Users should be able to provide their feedback for the order.

14. Restaurants should be able to register themselves to the system after the admin approved their registration.

15. Restaurants should be able to update costings , food items availability , Open and Close timings etc .

16. Users should be able to apply Coupon Codes On their purchase.



Code can be found at the last video, it's advised to finish all the videos before looking at it.

High Level APIs
1. Let’s Write down all the APIs we are going to need in our system. You can also Imagine or Go through some GUI and think of some APIs needed on your own.

2. First API we need is FoodItemSearcherAPI , Input to this API is foodItem Name and some filters (like veg or non - veg). And Output of this API is a List of foodItems present there in the System.

3. Next API we need is RestaurantSearchAPI.It is same as Above API But the Only change is that here we are giving input like Restaurant Name , Filter like italian Restaurant , veg restaurant etc , and in output we are going to get List of Restaurant present there in our system.

4. Let’s assume we have searched for some particular food Item ( Pizza ) using our FoodItemSearcherAPI . Now we will get a List of Pizzas available and when we click on some particular pizza then we will get the List of restaurants serving those types of pizzas (Like Dominos , PizzaHut etc).

5. Now For this Redirection to happen from food item Name to restaurant List, we will need the Restaurant IDs, Hence we will need an API GetReastaurantByID. Input to this API is Restaurant ID and Output from this API is Restaurant Name and details.

6. FoodItemSearcherAPI and RestaurantSearcherAPI these both are the Pure Search APIs. ALL the complex operations like string Matching etc will be performed by these APIs whereas GetReastaurantByID API will perform CRUD Operations. This is a Simple GET API. This will look into the database and fetch some data according to the input given.

7.We may also need a GetFoodByID API. this API will take input as some ID-Number and it will return the Details of that particular FoodItem.

8. All the API we discussed till now are the READ APIs. These will not change or update anything to the dataBase. Now let’s talk about some POST APIs.



9. We will need an ADDToCartAPI which will allow users to add food items of particular quantity in their Cart like 2 pizza’s , 1 Burger , 4 Garlic Breads etc.

Input to this API is some kind of UserToken and FoodItemId.

Output to this API can be NULL , or it may show some successful message to the user.

10. Another API we need is PlaceOrderAPI. This API will Help users to Place their Order in our System. By taking details of Payments and delivery etc .

Inputs to this API are UserToken , PaymentMode, PaymentInfo.

Output to this API is Order , where Order is a Separate Entity consisting of Details regarding order placed.

11. Some of you might wonder why we are not passing FoodItems inside our API , So the answer to this is to think from a bigger perspective. When our system is too large then there may be possibilities of error or it is difficult to handle such a large amount of parameters. Instead of passing foodItems we can figure it out using the UserToken itself.

12. There should be UpdateOrderAPI which will mark the order status accordingly whether it is placed or cooked or delivered . Input to this API are orderId, Status , UserToken. And output can be void or some sort of message “Updated Successfully”.

13. Remember , the entire logic is not contained in these APIs, APIs are very high level things. They need to consult some low level Business class which will contain the actual logic for work.

Designing Searcher
1. Let’s Design Our Searcher for the Food Delivery System. We will start By making a Class FoodItemSearcherAPI.

2. This class will contain a Method called SearchFoodItems()  Which will of type public and return us the List<FoodItems> i.e. List of FoodItems . This method will take following parameters (FoodName and Some filters)

String foodItemName

MealType mealType  , where MealType is an Enum

List<CuisineType> cuisines

StarRating rating

3. Now Let’s create a Folder Data inside our main folder and inside Data create Enum Files for above Methods.

4. First create a MealType Enum having types VEG, NON_VEG.

5. Next Enum is CuisineType with ITALIAN, SPANISH, GERMAN, ASIAN in it.

6. Another Enum we create is StarRating with ONE, TWO, THREE, FOUR, FIVE in it.

7. We will Also create a FoodItem Class which will contain following parameters

Private final int id,
Private final string name,
Private final string description,
Private final double priceINR,
Private final MealType mealType,
Private final CuisineType cuisineType,
Private final StarRating starRating,
Private final int restrauntID,
Private final boolean isAvailable,
These all will be initialized with a constructor
8. We will also create getters and setters for all these parameters.

9. In order to implement our FoodItemSearcherAPI ,We need to have a Business component called as searcher.

10. This searcher should be generic , This will work something like “ Get only those food items whose (name matches foodItemName ) AND (meal Type is mealType) AND (ct is CuisineType) AND (r>rating) .

11.This searcher should follow an open-close principle.

12. We can divide our query in two parts , first is matching part i.e. matching names with foodItemNames , and second part will be filters i.e. rest of the query.

13. Our filter may have a boolean value which takes input as foodItemName and returns True/False based on the Filter Criteria .

14. We can create an interface called FoodItemFilter which can have different implementations according to their requirements .

15. Now we can extend our Filters which will implement FoodItemFilter example

Public class MealTypeFilter implements FoodItemFilter.

16. This will have a constructor inside it and a method filter inside it. Which will contain filter logic.

17. Just like MealTypeFilter , we can create different filters, for example StarRatingFilter, CuisinesTypeFilter etc.

18. Let’s create a Searcher i.e. FoodItemSearcher  ,it will contain a Search method which will take List of FoodItemsFilters and a FoodItemName , and apply some Business logic to return List Of FoodItems passing the filter criteria.

Implementing Searcher

1. Just like we have FoodItemSearcherAPI , We need to have a RestaurantSearcherAPI.

2. Similar to FoodItemSearcherAPI , Our RestaurantSearcherAP will have searchRestaurant() method which will take following sets of parameters

String restaurantName,
MealType mealType,
List<CuisineType> cuisineTypes ,
StarRating rating
Return Type of this method is List<Restaurant> and this will be a public method.
3. Here in return Type of above method, Restaurant will be another dataclass .

4. This Restaurant class will contain following sets of attributes

Private final int id ,
Private final string name ,
Private final string description,
Private final BusinessHours businessHours,
Private final MealType mealType,
Private final List<CuisineType> cuisineTypes,
Private final StarRating rating,
Private final Menu menu,
5. We can see that declaring above attributes we have got two new data classes emerges out i.e. BusinessHours and Menu .

6. We will create a data class BusinessHours , This class will contain two attributes

Private final LocalDateTime startTime;
Private final LocalDateTime endTime;
These will be initialized in the constructor and also have getters for themselves inside the class.
7. Similarly we will create a Menu data class.

8. We will also generate getters for Restaurant class.

9. Just like FoodItemSearcher , we will also need a RestaurantSearcher.

10. Similar to the interface  FoodItemFilter , we will have a RestaurantFilter interface.

11. This interface will contain a boolean method called boolean filter(Restaurant, restaurant);

12.  Since our restaurant needs the same filters i.e. CuisinesTypeFilters , MealTypeFilter, StarRatingFilter . We don’t need to create these classes again , instead we can make it implement both FoodItemFilter and RestaurantFilter just like shown below.

public class StarRatingFilter implements FoodItemFilter , RestaurantFilter

{

}

13. We will do this for all filter types.

14. Now coming to the RestauratSearcher class , it will contain a Search method with following parameters

String restaurantName,
List<RestaurantFilters> filters,
And return type will be List<Restaurant>
15. The logic inside it is very much similar to search method of  FoodItemSearcher class.

Designing Cart Operations
1. Coming onto our Menu class , it will contain List of food items

private final List<FoodItem> foodItems ;
2. It will also contain a constructor and a getter.

3. Let’s create two more important APIs which we will be needed

GetRestrauntByIdAPI
GetFoodItemByIdAPI
4. These APIs will consist of public methods getRestaurantById() and getFoodItemById() which will take id as input and return Restaurant and FoodItem respectively.

5. Now Our FoodItemSearcher and RestaurantSearcher classes can have 1 more method each , i.e. SearchByID() , which will take id as input and return FoodItem and Restaurant respectively.

6. Another Important API we need to have is AddToCartAPI. This API Class will contain a method addToCart() of type void.

7. Since add to cart is a write operation , we need to carefully implement it and have to check multiple layer authentication.

8. addToCart() method will take String UserToken and int foodItemId as input parameters.

9. Since we are introducing a Cart Based functionality. We need to have some class which will manage our Carts while placing the orders .

10. Let’s create a class CartManager. This class will have a function called getUserCart() , return type of this function is List<CartItem>  and input to this function is user which is of Type User

public List<CartItem> getUserCart(User  user)
{
}
Where CartItem and User are different data classes.

11. Further our CartItem will contain two attributes

Private final FoodItem foodItem ;
Private final int quantity;
Also CartItem will contain a constructor for initialization and getters for attributes.

12. Similarly we will also create a User data class.

13. Now coming to our CartManager class , it will also contain a method addItemToCart().

public void addItemToCart(User user , FoodItem foodItem )
{
}
This function will help users to add items into the cart. We will write this api in such a way that it will add 1 unit at a time only.

Think of it like a plus button on our food item in UI. when we click on the plus button then 1 unit of the same order gets added into our cart.

14. Similarly there must be another function called deleteItemFromCart.

public void deleteItemFromCart(User user , FoodItem foodItem )
{
}


15. CartManager will also contain checkOutUserCart() method of void return type and Take User user as input. We can find out everything about Order just by using User user.

16. Now as we can see these methods are write methods hence we should create some authentication layers or permission layers for using these methods as there can be possibility that admin might have restricted some users to add remove or checkout due to some particular reason. Just think and try out some different approaches for implementing these.

Implementing Cart Operations
1. Let’s look into the addToCart method In AddToCartAPI Class . It will take Two arguments i.e. String UserToken and int foodItem.

2. Now to know which user we are referring to via this UserToken we need to have a UserManager Class.

3. UserManager is a very simple class which will tell us about the user we are talking about. It will contain methods getUserByToken() and getUserById(). Which are self explanatory from their name. Return Type of these methods will be “User”.

4. Now let’s come to the User Class and create some attributes in it.

Private final int id;
Private final String name;
Private final Address address ;
Private final String phoneNumber;
Private final String emailId;
5. We can see that we have declared a new data Type Address in the above creations. Let’s create this Address class.

6. This address will contain following attributes regarding the address of some particular user.

Private final String addressLine1;
Private final String addressLine2;
Private final String addressLine3;
Private final String addressLine4;
Private final String city;
Private final String state;
Private final String zip;
Private final String country;
7. In our AddToCartAPI we can create instances of User user and FoodItem foodItem which are our business objects. These business Objects will help us to interact with the CartManager class .

8. We will create the instance of cartManager class like this

Private final CartManager cartManager = new CartManager();
And we will then call the addItemToCart(user , foodItem ) method using this instance.

9. In our previous lectures we had talked about permission and access. There can be different levels of permissions and access in the system for example there are some users who have read access. Also there can be some users who have write or execute access.

10. There also can be different combinations of access given to different types of users. Different types of users can be admin , delivery Guy, Customer etc.

11. Instead of creating different classes for different types of Users having some sort of permission. What we can do is we can create an abstract entity called “Permission”.

12. Permission can have different types like AddToCartPermission, PlaceOrderPermission etc.



13. Permission will be an interface and its different types will implement it.

14. After that whenever we want to execute some operations we just use two parameters i.e. User user and Permission permission , and we will just check if the user has this permission or not .

15. Here we are recoupling User with the permission. Permission will be a simple interface with a method isPermitted() in it.

16. Let’s imagine we have to create a AddToCartPermission class then we will just make it implement the Permission interface and have a boolean isPermitted() function inside it .

17. Write the Logic inside isPermitted() method , declare important parameters and attributes for it .

18. One important factor is whether delivery is possible or not . Assume someone orders food from a very far restaurant (like 40-50 km away) then it is sometimes not feasible to deliver. Hence there must be a DeliveryManager class which will take care of these cases.

19. DeliveryManger class will contain a simple boolean method isDeliveryPosible() which will take restaurant address and customer address.

20. Just similar to the AddToCartPermission class we will implement different permission classes like CheckOutCartPermission , DeleteFromCartPermission, PlaceOrderPermission , UpdateOrderPermission etc.

21. In the UpdateOrderPermission class we will have these attributes.

Private final User user;
Private final Order order;
Private final OrderStatus orderStatus;
Here we are seeing some new data classes which are Order and OrderStatus. Hence we need to create them.

22. We will ensure that our business class CartManager will only depends upon abstraction i.e. Permission interface . We can do this via using factory patterns.

23. Let’s create a PermissionFactory class . The main work of this class is to provide us with instances of different permissions. Example : it will contain a method getAddToCartPermission which will  return new AddToCartPermission(user, foodItem) ;

24. Now in our CartManager , while implementing the Business Logic for addItemToCart method we see that we need to create a different method which will check if the food added into cart is from the same restaurant or from different restaurant.

Finishing up the Cart
1. CartManager Class needs an another entity for its addItemToCart method i.e. DataAccessor.

2. This DataAccessor class will contain all the members and functions which will execute the queries of the dataBase side and also the fetchers.

3. It will contain a private constructor and public static methods i.e. addItemToCart() and getFoodItemWithName().

4. DataAccessor will return a specific type of result that may be of JSON type string or something else.

5. Let’s create a DataAccessResult class for it so that our data accessor class can use it as return type.

6. DataAccessor can have many functions like getRestaurantWithName() etc.

7. Important method which dataAccessor will have is a getCart(User user) method of return type DataAccessResult. Which will fetch the User’s Cart from the Database table.

8. Now coming to our class CartManager , getUserCart() method We can use this above method of DataAccessor.getCart() But it will return result in DataAccessResult Format and we need it in List<CartItem> Format.

9. Hence we must need to have a converter class known as DataAccessObjectConverter .

10. It will contain a constructor and a method convertToCartItems()

11. While Writing some business logic for methods in CartManager we came to know that we need to have another private method inside CartManager which will check if a food item is present inside the cart or not i.e. isFoodItemPresentInCart().

12. When a User places an order then we must create an order in our database . For that we can create a new order_id in some order_table and which will be mapped with the Cart_table with the Cart_id. These things should be taken care while playing with databases.

PlaceOrder API
1. We will need to have a PlaceOrderAPI for placing the order.

2. This class will contain a method placeOrder() of return type Order (We will create this Order class Later on ).

3. placeOrder() will contain the following parameters.

String UserToken : this will Give the complete information about the User and Cart.

Map<String,String> paymentInfo : This Map will contain details about the Payment Info based on payment Mode . Example if Payment Mode is card based Payment then it will contain card number as a key and actual number as value.

Similarly if it is a netBanking based payment then it will contain otp as key and number as value etc.

String PaymentMode : This will be the mode of payment whether it is Card Based Payment or UPI based or NetBanking Based etc.

4. While writing business logic for the placeOrder method we will validate userToken and then validate User and after that we will validate Payment.

5. For Payment Related Task we must need a new PaymentManager interface.

6. This interface will contain method executePayment() which will be of return Type “PaymentRespose” .

7. So create a New java class PaymentResponse. The important fields in this class are

Private final double amount ;
Private final int id ;
Private final PaymentStatus status
Where PaymentStatus is an ENUM with types SUCCESS and FAILED.
8. Since there can be different Payment Modes, there must be different Payment Manager which will implement PaymentManger interface .

9. Let’s create a class NetBankingPaymentManager which implements PaymentManager.

10. This class will contain the following important fields.

Private final String bankName;
Private final String userName;
Private final String passWord;
Private final String pin;
Private final double amount;
Also a constructor will be there for initialization.

11. Similarly we can create CardBasedPaymentManager.

12. Now in Place Order API class, placeOrder method , we need to check for the payMent Mode , for this we can check it using if-else statements which is obviously not a good practice to do.

13. We can check PaymentMode using a Factory pattern. We can create a PaymentManagerFactory class.

14. This class will contain a constructor and some static methods i.e. getPaymentManager() which will need other static methods while implementation of business logic . Those methods are getNetBankingPaymentManager() and getCardBasedPaymentManager().

15. We can see that Our PlaceOrderAPI only needs to know about PaymentManager interface which is an abstract thing. It does not need to know about NetBankingBasedPayment or CardBasedPayments .

16. This is possible because of our factory design pattern.

17. To manage the placed orders we need to have an OrderManager.

18. This class will not have to do anything with payment. It will simply fetch the cart of the user and looks what are the food items which are present there in the User Cart and then it will map the food items with order id.

UpdateOrder API
1. Order is a data class we need to have in our system. This will contain the following attributes.

Private final List<CartItem>cartItems;
Private final int id;
Private final int userID;
Private final OrderStatus orderStatus;
Where OrderStatus is an ENUM with types

ORDER_PLACED,
COOKING,
READY_FOR_DELIVERY,
OUT_FOR_DELIVERY,
DELIVERED,
CANCELED
2. For placing orders ,we need to get the permission and for that we need to have the Permission getPlaceOrderPermission() method inside our permission factory .

3. We will write business logic for the placeOrder() method in OrderManager class after implementing getPlaceOrderPermission() in the factory.

4. OrderManager needs to have another important public method getOrders() which will be of return type List<Orders> and take User user as input.

5. This method will return the list of orders users have.

6. Updating is another important parameter we need to consider. UpdateOrderAPI will be used by admins ,chef ,delivery Guy etc to mark order as PLACED, COOKED, DELIVERED etc respectively.

7. UpdateOrderAPI will have the instance of UserManager and OrderManager which will be used inside the method updateOrder() for updating the order.

8. In our orderManager class we can have a method which will set the order to cooking after the order is placed . for that we will implement a method setOrderToCooking(User user, Order order).

9. Now for this purpose we need to have permission from the permission factory hence we will create a class UpdateOrderPermission which will implement permission.

10. Similarly we will have a method

setOrderToReadyForDelivery(User user, Order order)  ,
setOrderToOutForDelivery(User user, Order order) , setOrderToOutForDelivered(User user, Order order),
setOrderToCanceled(User user, Order order)
Code Link : Food delivery system 