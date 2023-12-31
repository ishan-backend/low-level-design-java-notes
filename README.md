**Install OpenJDK 17**:
https://medium.com/java-mvp/install-openjdk-17-on-macos-c0ddb3ac9f0e

**Problem Statements Collection and whether solved (Yes/No)**:
- Implement online payment aggregator with multi payment gateway module

**Most important things in LLD interview**:
- Components you have written should be:
    1. Extensible
       1. SOLID principles
    2. Maintainable
        1. Cleanliness of code
        2. Variable Naming
        3. Modularity of code
    3. Functional Correctness
       1. At times, it might not be possible to ensure functional correctness across all real-world scenarios in interview
       2. May have certain bugs / edge cases are remaining are relaxable if overall design is Good (extensible + maintainable).

3. **Separation of Files**:
    ```
    - enhanced code maintainability e.g. classes2 package
        - to solve bugs, go to just one file. Less resource / dev intensive to solve bugs
    - helps in testing, write a test class for your class
    ```

2. **Class**:
    ```
    - Class is construct that helps us to separate code into files.
    - Purpose to create class - put together related data + algorithms (method/function).
   
    - In a software world if we want to design a system then there are multiple entities that it will have , and each entity represents a class and each of this class have their own data and own sets of functions.
    - Example : e-commerce websites like amazon have different entities which are payment Gateways , orders , shipments , cart etc . because they all deserve different classes.
    
    - The Art behind a good LLD is to be able to think about the correct entities and the right kind of relationship / dependencies between them. 
    
    - The logical representation of class [Class Diagram] in a box:
        - Class Name / All Data Members <name, type> / All Member Functions
    - The dependencies  between these multiple classes / entities is shown by an Arrow  in a class diagram.
        - C2 can depend on C4 to create an object etc. 
    
    - e.g. to think about all possible member functions of FileSystem class:
         string getAbsPath()
         double getSize()
         void delete()
         void move()
         void copy(String path)
         void addContent(String content)
    ```
   
3. **Objects**:
   ```
   - Dynamic Memory Allocation
   - for e.g. in case of struct, we dont have any memory allocated (in RAM at runtime) to a struct until its initialised.
   
   - Defining a class does not create a object
   - using New keyword with constructor, creates an object
      - all data members of class instantiated are instance variables, and do not belong to class
   
   - All the objects of same class have same methods
   - Methods may behave differently for different objects, because diff objects have different data
   - 
   ```
   
4. **Access Modifiers**:
   ```
   
   * private
   * public
   * protected
   
   - declare something as private (var / method), is accessible from only inside that class.
   - Is it a good practice to keep data member as public or private?
      * public - data contained in a particular object gets changed in some other class.
   
   - public methods - getters - to access private values of an object of a class has.
   - similarly, setters - give access to third party classes to set values.
   
   - a private method cannot be called directly from outside the class.
   - low level methods - containing core logic which other users/classes need not know should be kept private.
   - other methods can be provided as public that can be accessed from different class and package.
   
   - protected - can be accssed from within the class and outside the class from same package.
   - inheritence has parent child relationship - across classes - this class maybe in separate package,
     but still it would be accessible since it uses inheritence.
   
   - if you dont mention any access modifier for a data member, you are granting access to it on same package level. Default = Protected - inheritence
   ```
      
5. **Static Variables / Methods**:
   ```
   e.g. Math.sqrt(25) or Math.Pi
   - here Math is a class, which contains method sqrt.
   - You are invocating a method of class directly from class name, which is not object oriented way.
   
   - These methods and variables are static in nature.
   - Whatever is static, you can access it by using classname directly.
   
   public class File {
      private int path; // instance variable - will be different for different objects - all objects have different copy of these instance var in-memory.
      static int count; // does not belong to object but class - one & only one copy in memory/RAM, and different objects will have reference to it.
   }
   
   Examples of static variables:
   e.g. Write code to track number of objects created by file class.

   Examples of static methods:
   
   
   ```

// todo: complete oops 


20. **SOLID Principles**: <br/>
    a. *Single Responsibility Principle (SRP)*:
      ```
      * SRP Example:
         - Company Entity
         - Employee Entity
         
         // Multiple reasons to change
         // Employee attribute mgmt, Salary logic, Perf. Report Logic, Bio Data Retreival Logic
         public class Employee {
            private id;
            public getId();
            public calSalary(); // - would depend on external factors - bonus, esops, leaves
            public printPerformanceReport();
            public printBioData(); // - ext. factors confidential data which we dont want to keep
         }
         
         - Employee class has to change a lot under different situations
            - HRs change biodata
            - Managers change Bonuses/Performace report
            - Managers change something in reports
         
         
         -> "A class must have only one reason to change" - SRP
            or
            "As long as you have a class, which can change due to multiple reasons, its not abiding SRP"
            
         -> Delegate responsibility to new classes
         class SalaryCalculator {
            public calSalary(Employee e)
         }
         
         class PerformanceReportPrinter {
            public printPeformanceReport(Employee e)
         }
         
         class BioDataRetreiver {
            public retreiveBiodata(Employee e)
         }
         
         class Employee {
            // only employee attribute mgmt.
         }
         
         - Creating such classes reduces code fragility.
      
      ```
    b. *Open Closed Principle (OCP)*:
    ```
    Example use-case:
        - Make a game of superheroes vs enemies
        - Feature: player can attack using multiple superheroes
        - Different superheroes have different way of attacking
        
        enum SuperHeroes    
    
        class Attacker {
            public attackWithSuperHeroes(List superheroes) // uses switch statement
        }
    
        - uses switch which needs to be changed again on addition or deletion of superheroes
        
    - To solve this (rigidity of code) - unable to extend to new features without modifying class/package:
      We should be able to do it & this should not happen.
    
    - Ideal expectation: Attacker should only know about Superhero (Abstract) & not concrete things(CA, Ironman)
    
    "Coding to abstractions & not to concretions"
    - We can introduce polymorphism to get away with this problem.
    "A class should be open for extension, but closed for modification"
    
      
    interface SuperHero {
        attack()
    }
    - all concrete classes (im, hulk, etc) impl this interface 
    - Attacker class now has to depend on interface SuperHero, rather than indiv. im, hulk, etc classes
    - Attacker -> SuperHero <- {IM, Hulk, etc}
    - thus it removes if/else or switch conditions
    - keep SuperHero inteface and classes (IM, Hulk) in one module
    - keep Attacker class in separate module for different team to work on
    ```
    c. *Liskov Substitution Principle (LSP)*:
    ``` 
    - Inheritence - inherit some/all properties from parent.
    - SuperClass & Children/Derivatives {subclass1, subclass2, etc} via extend - it inherits all public, protected dm & mf.
    
    - Abstract Class - special class which could not be instantiated.
    e.g. Company can have diff kind of employees
    - Full time
    - Intern
    - Contractual
    - Consultant
    - Volunteers // do not want salary for work
    
    They have strict "is-a" relationship with this Employee Class
    abstract class Employee {
        abstract calcSalary(); 
    }
    
    - Concrete classes for Full time, Intern, etc.
    - Full time will have its own implementation since it would have stock options + salary, similarly for others except Volunteers.
    - Volunteers dont want calSalary() method, say 500 volunteers dont need any accounting for salary
    - First way, we can throw exception whenever calSalary() method is called, since we inherited from base class without thinking properly and now we are forced to do an implmentation.
        - Issues:
            - New Module(Salary disbursal) -> Employee <- {FTE, Volunteer, Consultant} => We would need special handling in New Module class for exception
    
            
    - Second way (better), Inheritence got us tricky. We will discuss later.
        - "Never Use Inheritence for purpose of code-reuse" (we wanted data members from Employee, but also had to implement calcSalary() unnecessarily)
        - "Use Inheritence only when there is strict "is-a" relationship", e.g. FTE is employee in all ways, but volunteer is not.

    "Subtypes(Subclasses) should be substitutable for base classses/ super classes"    
    ```
    
    d. Interface Segregation Principle:
    ```
    example use-case:
        Cricket Game:
        "When designing systems, we design it in a way that external systems rely on abstractions rather than concrete classes"
            * Entities:
                - Player (interface) with methods:
                    - bat()
                    - bowl()
                    - field()
                    - wicketKeeper()
                    - rest()
                    * Various concrete classes will be implementing this interface.
                        - Variety of players (pure batsman) doesn't need to have bowl() but needs field() and bat()
                            etc.
                        - Each of the concrete classes require a subset of these methods.
                        - 4 Batsman, 4 All-rounders, 2 Bowlers, 1 Wicketkeeper
                    * We cannot directly create implementation since we would have to catch exception from various classes. 
                        Concrete classes are being forced to implement methods they dont want to.
                    * We cannot solve this using single interface.
    
    * Inheritence Hierarchy is tricky.
        - we did not find strict "is-a" relationship above:
        - Think all of below classes are abstract classes:
            - Player{bat()} <- Fielder{Field()} <- Bowler{Bowl()}
            - Player{bat()} <- Keeper{Keep()}
        - And now you can plugin concrete classes like PureBatsman under Fielder() since it requires both bat() and field()
        - Catch:
            - In future, if rules of game change, will you be up for trouble?
                - Entity X requires just bowl() and bat() & we dont want field()
                - So, new entity is having all properties from root to leaf.
                - Code is not robust enough, to handle future use-cases.
    
            - Solution:
                - New Entity might be composed of subset of behaviours.
                - "Interfaces = Behaviours e.g. bat, bowl, field, etc"
                - Instead, of just one interface, multiple interfaces
                interface Player {
                    bat()
                    field()
                    rest()
                }
                interface Bowler {
                    bowl()
                }
                interface WK {
                    keep()
                }
    
                - We can implement these multiple interfaces in concrete classes now.
                * Each concrete class "Composed-of" subset of behaviours/interfaces, by implementing them.
                * Multiple small interfaces, is better than single interface.
                e.g. use-case:
                    Handle Data:
                        Behaviours- read/write
                        interface Read {
                        }
                        interface Write {
                        }
    
                        Concrete implementations/entities:   Read-Only-Data-handler, Write-Only-Data-handler,  read-write-data-handler.
    
    * Clients/Classes should not depend on methods that they dont use.
    ```
    e. *Dependency Inversion Principle (DIP)*:
    ```
    - New Module depends on abstractions (abstract class or its derivative / interface) not concretions (concrete class)
    - example use-case:
        - E-Commerce:
            - Purchase Flow:
                - Payment Processing:
                - Notification Sending:
        
        Interface PaymentProcessor {
            processPayment()
        } <- Class PurchaseFlowManager
        Interface NotificationProcessor {
            sendNotification()
        } <- Class PurchaseFlowManager
    
        PaymentProcessor <- NetBankingProcessor, UPIProcessor, etc.
        NotificationPrcessor <- EMailBasesSending, SMSBasedSending, etc.
    
    
    DIP - "High level module should not depend on low level module"
    "Rather both should depend on abstraction"
    
    High level module - PurchaseFlowManager Class
    Low level modules - NetBankingProcessor, UPIProcessor, EMailBasesSending, SMSBasedSending Classes
    Abstraction - PaymentProcessor, NotificationProcessor interfaces. 
    
    "DIP Asserts OCP"
    - High level module doesn't care (no change/recompilation) if new low level modules are introduced
    - You can use abstract classes also in place of interfaces i.e. all low level modules will inherit from abstract class
    - Interfaces/Abstract class defined once are very less likely to change in future
    - High level module should not contain any other concrete class except String, other data structures which are also concrete classes but no changes are made to them
    
    
    * Dependency Injection: - Allow clients/users of high level module to inject dependencies/instances/implementors of interfaces they want to use via constructors.
    public class PFM {
        private final PaymentProcessor P;
        private final NotificationProcessor N;
    
        public PFM(__ P, __ N) {
            this.P = P;
            this.N = N;
        }
    }
    
    - X*Y concretions/behaviours can be made out because of DI.
    - DI can be done by Constructor / Function:
        setPaymentProcessor(__ P) {
            this.P = P;
        }
    
    - writing such code delays "new()" keyword. -> Allowing client to use new() keyword
    - writing unit tests is easy
        - create a mocked object of paymentProcessor and inject it, so you can have full control of those objects
        - define rules m.makePayment() does nothing
        - third party classes would be mocked
    
    - You are violatin the DIP when-
        - Arrow from one concrete class lands directly on other concrete class.
    ```

21. **Composition Over Inheritance**:
    ```
    * Perils of Inheritance:
        - Y <-extends-- X <-extends-- Base Class: you bring in everything present inside a class.
            e.g. LSP - when you extend a class using inheritence for code-reuse which might land you in trouble for subclasses where cetain DM/MF doesnt make sense.
                LRU Cache extends Hashmap - Other methods in Hashmap dont make sense for LRU Cache. Certain methods dont make any sense to invoke on LRU Cache.
        - debugging becomes very very difficult when you create long chains.
    
    
    * Prefer Composition Over Inheritence:
        - example use-case:
            classes: Reader (read(), ...), Writer(writer(), ...), Worker
            Worker wants to implement read() and write(), so if it extends from both classes, it will have to implement other methods too which doesnt make sense for it.
        
        - So, if Worker could encapsulate reference to Reader() and Writer() in it.
        It won't have to implement the methods, rather call Reader.read() and Writer.write() methods from within it.
        "It's not liable to override other methods since its not inheriting"
        "Debugging, readablility, extensibility - much better with composition than inheritance"
            - since if debugging, you know where you have injected reader, and writer in worker.
    
        
        - "When you are using inheritance, give second thought which makes more sense, can composition?"     
    ```


22. **Right way to approach LLD Problem**: <br/>
    ```
    Two reasons why you would find a LLD Problem hard?
    1. You dont know what to design?
        - Do Concrete Requirement Gatherings very clearly
            e.g. Design Amazon:
                    4-5 Requirements clarification
                    Data to store
                    APIs
    2. Unstructured thinking?
        e.g. You made Product, Cart, Price classes (low-level/independant) and were not able to establish relations between them.
        So you followed bottom-top approach. This does not work.
    
        e.g. Design House Problem:
        Cant design drawing room, toilets, bathroom, bedrooms first and then weave them.
        
        - Top-Bottom Thought process: (For all LLD/Machine Coding Problems)
            * Think around GUI (Web/Mobile) and user interactions [No points on this from interviewer]
                - gives you idea around APIs, parameter and response
                - think around possible flows - features, clarity of input of FE sends to backend
            * Think about database tables [No points on this from interviewer]
            * LLD is mediator in b/w GUI and Database - which is server (LLD);
                - Thinking about GUI and Database gives you hints
                - You won't come up with most robust code in one iteration
                - But your design would be functionally correct & pluggable in end to end system
            
            - APIs are functions & req payload is parameter to those function
            - Imagine then GUI and Database are abstracted out, then focus on LLD designing. 
            - Store data in maybe Hashmap in-memory to mimic DB.
    ```


23. **Case-Studies: Easy**: <br/>
    a. *Generic things about LLD*: <br/>
        ```
        - 
        ```

24. **Case-Studies: Medium**: <br/>
    a. *Food Delivery System*: <br/>
    ```
    * Requirements: (Draw it from Feel of GUI)
            1. Search + Filters:
                - Users should be able to search for food items &/or restaurants by their names.
                - They should be able to put filters (Meal-Type: (Veg/NonVeg), Cuisine-Type: (Italian + German), Rating > 4 stars, Close to my location etc)
                    
            
            2. For fetched food item, navigate to associated restaurant, check menu/price-list, add items to cart and place order.
            3. Different modes of payment should be supported (Netbanking, Cardbasedpayment)
            4. A cart cant contain food items from multiple restaurants.
            5. System should contain important info for delivery like delivery address, contact number
            6. User should be able to track order status: ORDER_PLACED, COOKING, READY_FOR_PICKUP, OUT_FOR_DELIVERY, DELIVERED, RETURNED. Certain user personas can make state change from initial to final, depending on use-case.
                - A user can cancel order, if order status is <= COOKING
            7. System should provide ETA for delivery.
            8. User should be able to provide rating+feedback for order.
            9. Restaurants should be able to register on platform. Admin approval needed.
            10. Restaurants should be able to update costings, food item availability and open/close timings.
            
            BONUS:
                a) Coupon Codes
                b) Notification system
    
    * Approach:
        1. High Level APIs (Decide on important APIs needed from GUI aspect)
                a) Food Item Searcher API
                    i/p: String FoodItemName, Filters:  
                    o/p: List<FoodItem> 
                b)  Restaurant Searcher API
                    i/p: String RestaurantName, Filters:  
                    o/p: List<Restaurant> 
                c) food item from searcher api to - web page with restaurant details (food item id, restautant id)
                    GetRestaurantById API
                    i/p: Integer rId
                    o/p: Restaurant
                d)  GetFoodItemById API
                    i/p: Integer fooditemId
                    o/p: FoodItem
                e)  AddToCart API (user authentication JWT token needed )
                    i/p: UserToken, foodItemId
                    o/p: 200 OK, item added to cart successfully
                f)  PlaceOrder API
                    i/p: UserToken, PaymentMode, PaymentDetails
                    o/p: Order (id, status, ...)
    
                    DB Cart Table: user_id, food_item_id, bool checked_out
                g)  UpdateOrder API
                    i/p: order_id, new status, user_token
                    o/p: 200 OK, status update successfully
    
        2. Create Different classes for different APIs. Those classes will have function for the API.
           Tester class main method will create instances of these classes, and will call methods.
        
        3. Think of Business Classes with SOLID principles, extensibility, cleanliness:

            * FoodItemSearcher API
                - ENUMs and certain ENUMs would be required as range filter e.g. StarRating
                - FoodItem class with associated DB cols as fields with constructor and getters
                 
                - Searcher is Business Component, should be generic searcher (OCP)
                        - it has to fetch from database items which has similar name
                        - with same meal type
                        - with same cuisine type
                "get only those food items where name=foodItemName and (mT is mealType) and (cT in CuisineType) and (r > Rating)"
                - Since with passage of time, filters length might increase and their logic will change overtime, we will keep it seperately in filters F1, F2, F3
                    - F1 (mT is mealType) 
                    - F2 (cT in CuisineType) 
                    - F3 (r > Rating)
                    Also different filters mean different algorithms.
    
            * RestaurantSearcher API
                - with introduction of this, filters merge with above api as well
    
            * 
    ```


30. **TESTABILITY**:

    * *Test Driven Development*:
        * First write unit test classes for the actual classes you have written.
        * Coverage report - line coverage, branch coverage reports.
        * Unit tests covering all the scenarios.
        * Real classes written in the best possible manner following LLD principles.
        * Unit - individual part of large complex system. We test for one particular thing/class at a time. i.e. We test one class.
            * We sideline other dependencies like classes , external resources - third party servers, cache, db.
                * Mocking is used to sideline dependencies.
            * New developer can write and test his new class.
            * Unit tests failing points to any class with the bug in development.
        * Unit tests are class specific - Functionally correct class, well-designed and presented independently. All SOLID principles, and best of design patterns.
        * Unit tests fail before building. So that prevents buggy code getting deployed to production.
        * Write Expected inputs, and outputs.

    * *Phases of Unit Testing (3 phases)*:
        1. Initialise the system under test -> Single class or group of classes
        2. Invoke system under test -> invoke method
        3. Compare expected and actual result -> Sometimes you want to compare behaviours also (exceptions, internal method calls etc.)

    ```java
        
    ```
