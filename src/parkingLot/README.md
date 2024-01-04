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

**Decoupling/Separation of responsibilities- finding a spot , FindParkingSpotAPI ; - allocating spot , GetTicketAPI**

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
* Write APIs classes first