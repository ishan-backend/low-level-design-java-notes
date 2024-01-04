**Requirements**:
* Build stock trading application like Zerodha
* You have multiple stock exchanges - BSE, NSE; These exchanges are constantly releasing some updates
* Format of one update: [Stock A, Rs. 100, ts/version number]
* There are multiple subscribers who consume these updates

* Clearly an example of Pub-Sub Model (Many to Many relationship)
* Example:
  * 1 Stock exchange: N publishers
    * each publisher : stream of messages of stock updates [Stock A, Rs.100, ts/version number]
    * Same stock updates are sent in any order by all publishers
      i.e. Publishers will release updates in different frequency, since there is no inter-connection between them. They are all individual entities.
  * M subscribers(actual users):
    * if it has subscribed to 2 stock exchanges, it will receive updates from 2+ publishers

**Implementation Steps**:
* IStockPublisher interface methods:
  * void subscribe(StockSubscriber)
  * void unsubscribe(StockSubscriber)
  * notifySubscribers(StockName stockName, StockValue stockValue)
* Concrete implementation of IStockPublisher:
  * StockUpdatePublisher
    * implements all methods
    * keeps private list of subscribers
    * state - name of publisher (BSE/NSE)
    * public constructor
  * _Publisher for BSE/NSE will do exactly same thing as above, we had requirement of multiple publisher, so instead of writing different classes for them. Have same class but have state name, and different publishers can maintain different state by having different objects_
* Concrete implementation of IStockSubscriber:
  * StockUpdateSubsriber
    * implements all methods
    * keeps private list of publishers
    * state - name of subscriber, data-store: hashmap of stock name, stock value
* Define Data classes: StockName, StockValue, Currency
* Implement updateStock method of subscriber with logic
* Now, run & test using Main function:


**Other questions using Observer pattern / Pub Sub model**
1. Notification system for social-media service
   * notification is published by (IPostPublisher) to a list of users/subscribers (IPostSubscriber)
     * Concrete implementation List (categories of subscribers, which react to these updates differently) can be of AdminUsers, NonAdminUsers, UsersWhoCommentedOnAPost, UsersWhoLikedOnAPost, UsersWhoCreatedAPost, PostHasChanged
     * These individual subscriber classes will be initialised with their states - list of users in them
   
2. E-Commerce store - buy and iphone(out of stock), then when inventory is backup again, request it to inform you.
   * (IInventoryPublisher) publishes to subscribers
   * Concrete implementations of IInventoryPublisher: IPhoneInventoryPublisher, VivoInventoryPublisher etc
   * (IInventorySubscriber) concrete implementations: CustomerSubscribers with hashmap state, SupportStaffSubscribers with hashmap state