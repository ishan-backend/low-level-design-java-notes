Implement a movie ticket booking system for a theatre
* 1 Theatre has multiple screens, that run shows at different times for different movies
* Assume all users are registered, authenticated and logged in to app
* Once a user selects a particular show to book tickets - UserBookingSession starts. Within this session, user will be able to get the available seats and select seats he wishes to book. Good to have - a limit on the number of seats a user can book in a ticket.
* Once a user has selected some seats, they should become temporarily unavailable to other users.
* If user proceeds to make payment, it will either SUCCEED or FAIL
  * If payment FAILED - user can retry for some maximum no of times, beyond which seats will again become available
  * If payment SUCCEEDED - ticket/booking confirmation is made available to user, UserBookingSession is closed, and seats become permanently unavailable.
* **Note:** A user can also explicitly close the app, before making payment after selection of seats in a UserBookingSession. In this case, seats are made available again. In this case, have a configurable timeout after which session is closed and seats are made available.

**Demonstrate**:
* Two users U1, U2 concurrently in the system.
* Users can retreive available shows and select one show too.

Case 1:
* Say U1 and U2 select same show.
* U1 requests for and gets all Available Seats for this show.
* U1 selects group of seats and proceeds to pay.
* U2 requests for and gets all Available Seats for this show. U2 should not see the seats selected by U1 as AVAILABLE. 5 .Payment succeeded for U1.
* U1 receives Ticket with Seats confirmed.

Case 2:
* Say U1 and U2 select same show.
* U1 and U2 requests for and gets all Available Seats for this show.
* U1 selects group of seats.
* U1 proceeds to pay.
* U2 requests for and gets all Available Seats for this show. U2 should NOT see the seats selected by U1 as AVAILABLE.
* Payment failed for U1. Assume maximum retries as zero just for the demo. Also show in another scenario where U1’s UserBookingSession is explicitly closed by U1 before payment is completed.
* U2 again requests for and gets all Available Seats for this show. U2 should now see the seats previously selected by U1 as AVAILABLE.

Case 3:
* Say U1 and U2 select same show.
* U1 and U2 request for and get all Available Seats for this show.
* U1 selects group of seats and proceeds to pay.
* U2 selects overlapping group of seats and proceeds to pay. U2 should be notified that “one or more of the selected seats are not available at this moment”.

Bonus:
* Have a configurable timeout for a UserBookingSession. Show that if User selects and Payment is not completed by timeout, then the UserBookingSession is closed and the seats selected are made AVAILABLE.

Expectations
* Create the sample data yourself. You can put it into a file, test case or main driver program itself.
* Code should be demo-able. Either by using a main driver program or test cases.
* Code should be modular. Code should have basic OO design. Please do not jam in responsibilities of one class into another.
* Code should be extensible. Wherever applicable, use interfaces and contracts between different methods. It should be easy to add/remove functionality without re­writing entire codebase.
* Code should handle edge cases properly and fail gracefully.
* Code should be legible, readable and DRY

Guidelines
* Use of DB not expected. You can store data in memory.
* Please discuss the solution with an interviewer
* Please do not access internet for anything EXCEPT syntax
* You are free to use the language of your choice
* All code should be your own
* Please focus on the Bonus questions only after ensuring the required features are complete and demoable.

**Implementation steps**:
* apis - controller layer/UI facing layer
* exceptions - holds all exceptions
* model - holds all entity classes
* providers
* services

* Step 1: Think about problem and identify entities / models
  * Theatre will have multiple screens
  * A Screen will belong to a theatre, and will have a list of seats
  * A Seat will belong to a screen, and will have seat no and row no
  * Show will be on a screen for a movie, for a certain duration and has certain start time
  * Booking: is made for show, for some seats, for certain user, and will have a status
  * SeatLock: provides lock for the seat temporarily while booking
  
* Step 2: Controllers/APIs:
  * (logged in and authenticated): Theatre -> Movie ->  Show -> Booking -> Payments
  * Some controllers will be user-facing, some will be internal admin monitored
  
  1. TheatreService and TheatreController:
  2. MovieService and MovieController:
  3. ShowController and (TheatreService, MovieService, ShowService, ServiceAvailabilityService):
  4. InMemorySeatLockImplementation
  5. Once you make payment, get seat -> you create a booking
     1. Model: Booking
     2. 