**Requirements**:
* In a big shopping mall, parking your vehicle:
  * Find a suitable place to park car/vehicle of your size which is vacant (Entry)
  * Come back after sometime, pay the fees and get out (Exit)
* Cases:
  * Talk to application at Gate (Entry/Exit) 
  * Figure out parking spot for a particular vehicle (multiple kinds of vehicle)
    * 2 - wheelers
    * 4 - wheelers
    * heavy vehicles
    * Different parking areas for all of them
    * Fees are different for different vehicles (more for heavier)
  * Parking has multiple floors, different areas for each vehicle type
  * Multiple entry gates, multiple exit gates
  * At entry:
    * Ticket is dispensed which contains - slot number to park your vehicle
  * At exit:
    * Show ticket to a person, he will tell the amount to pay
    * Payment is static on hourly basis (different for different vehicle type), mode of payment:
      * cash
      * card
      * UPI
    * At exit gate, we pay the amount
  * Selection of slots:
    * multiple strategies to give slot number
    * - nearest free spot to entry gate 
    * - random selection

**APIs**:

**Decoupling/Separation of responsibilities: for finding a spot -> FindParkingSpotAPI ; for allocating spot -> GetTicketAPI**

at entry:
* FindParkingSpotAPI(EntryPoint, VehicleType, SpotSelectionStrategy) -> Returns ParkingSpot
  * EntryPoint - at certain gate, we will have certain strategy to find slot
  * VehicleType - different vehicle to different areas
  * SpotSelectionStrategy - Random/NearestFirst
* On success of FindParkingSpotAPI, GetTicketAPI(ParkingSpot, VehicleDetails) -> Returns Ticket

at exit:
* PayParkingFeeAPI(Ticket, PaymentDetails) -> Returns Success/Fail
  * PaymentDetails
    * strategy for payment (card, upi, cash) will be different so its necessary to pass
* On success of PayParkingFeeAPI, VacateParkingSpotAPI() -> change state of ParkingSpot to FREE

**Classes**:
* Write APIs classes first:
  * FindParkingSpotAPI Class with public method which returns ParkingSpot
    * EntryPoint should be Data Class (not enum), in future if you want to add EntryPoint you just have to add them to DB without touching application code.
      * can have certain attributes (name, isOpen)
    * VehicleType - ENUM , since this is not changing frequently
    * SpotSelectionStrategy - Random, NearestFirst, ENUM
  * Make the Data classes for above arguments
  * Implementation:
    * Approach 1:
      * because there are different parking areas for different vehicle types
      * invoke different functions, which could run different queries for different vehicle types using if-else
        ```java
        if(...){
          concreteT1.do()
        } elseif(...) {
          concreteT2.do()
        } else {
          concreteT3.do()
        }
        ```
    * Approach 2:
      * Create IVehicleTypeManager interface and all of implementations can be concrete type
      * We create package manager for it, with interface IVehicleTypeManager with methods:
        * List<ParkingSpot> GetParkingSpots();
        * double getParkingFees(double durationHours);
      * IVehicleTypeManager has 3 concrete implementations:
        * TwoWheelerManager, ThreeWheelerManager, HeavyVehicleManager
        * We want to instantiate these classes **using Factory** (all creation logic should reside in a single class) - VehicleTypeManagerFactory
          * keeping factory stateless
            * constructor is private
            * all other methods static
          -> users of factory wont have to use new keyword for creating its objects and invoking methods
      * DIP - code for abstractions rather than concretions
        * frees you from nasty if-else checks
        * enjoy better extensibility on high level classes
        ```java
        abstractT.do()
        ```
    * Spot Selection Strategy:
      * a function which takes in arguments() - does some logic and returns ParkingSlot
      * nearest strategy depends on entry gate, while random one does not
      * Factory function
        