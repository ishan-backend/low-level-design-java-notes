**Requirements**:
1. ATM has various functionalities:
   1. Withdrawl of cash -> we will focus on this
   2. Check balance
   3. Deposit Cash
2. Constraints of ATM Machine:
   1. A user once inserted card, till he takes out, no other person can use this ATM machine. No concurrent transaction from one machine.
   2. Steps:
      1. Start transaction and machine asking to insert card
      2. Insert card
      3. Read card details and validate it
      4. If not valid, card rejected and EOT
      5. If valid, move ahead. System to ask next step : amount to withdraw
      6. Validate if amount can be dispensed or not
         1. User balance
         2. ATM balance
      7. Failing at some insertion/processing step, before dispensing amount, one must be allowed to cancel transaction
      8. Once amount is dispensed, one should not be allowed to cancel (machine should not take)
      9. If ATM is idle, one should not be allowed to cancel

**Thinking about flows and deciding APIs**:
1. Start button -> StartTransactionAPI() which returns transaction ID
2. Cancel button -> CancelTransactionAPI() cancels, and card is ejected out
3. Submit Card -> Card details sent to backend, validate. Two flows: new screen to enter amount, else stop transaction and eject card.
4. AmountDebit -> Amount value sent to backend, validate. Two flows: if not allowed, stop txn, eject; else dispense amount via cash. Call Approve API when success and stop the current transaction and record it, eject card.

**Steps**:
1. Design initial ATM class with all methods thought above.
   Shortcomings:
   1. Current ATM Class has no other fields, which differentiates it from any other ATM in some other region in the country, and inside system there is no differentiator between those objects.
      * Lets call it Machine Id (private field) -> if someone has to create an instance, he has to pass this machine id
   2. If a person has started his txn, how do you block other person to start txn on same machine.
      * ATM state machine -> depending on state, we will have access modifiers in functions.
      * States and their transitions:
        * EVENT ; INITIAL STATES -> FINAL STATES
        * init; {ready} -> {card_reading}
        * cancel; {card_reading} -> {ready}
        * read_card; {card_reading} -> {intermediate state}
        * invalid; {intermediate_state} -> {card_ejecting}
        * eject_card; {card_ejecting} -> {ready}
        * valid; {intermediate_state} -> {withdrawl_details_reading}
        * read_withdrawl_details; {withdrawl_details_reading} -> {second_int_state}
        * cancel; {withdrawl_details_reading} -> {card_ejecting}
        * invalid; {second_int_state} -> {card_ejecting}
        * valid; {second_int_state} -> {cash_dispensing}
        * dispense_cash; {cash_dispensing} -> {card_ejecting}
        * cancel; {cash_dispensing} -> {card_ejecting}
2. Add machineId and state to class and add constructor
3. Implement init()
   * This handles not allowing multiple users access to start transaction at same ATM at same time.
   * With introduction of more states, we require more if check additions to throw exceptions for invalid states.
   * These checks would be duplicated at all functions, looking at above state machine.
   * Since behaviour of those functions will differ depending on current state.
4. **Handling multiple states**:
   * Using state machine - State Design Pattern
   * Since behaviour of API changes with respect to current state and next state
5. Dependency Inversion:
   * **Single Responsibility Principle**: All of the information about how a function behaves on a state, must reside with a class about that particular state e.g. CardReadingState Class
   * We will have as many classes, as there are states. And each such class will have methods for specific behaviour like init, cancel, ejectCard, etc.
   * And we will have instance of CardReadingState class in ATM class, still that would violate OCP as functions would still have if-else conditions to call init of particular state
   * We violate **Dependency Inversion Principle** here, as we must depend on interfaces
   * **Introduce State interface** and ATM would depend only on this interface and all concrete state classes implement this interface
6. **Now we have State Pattern**:
   Your core class, depends on abstract class/interface called State, which has different implementations.
   Within those implementations -> information of how to behave for different transitions and what change to bring about is contained. 
7. **ATM class issues**:
   1. this.atmState = new ReadyState(this); // still ATM depends on concrete class
   2. whenever we are initialising ATM object, we are creating ReadyState object, which can have functional impacts
   > To support distributed set of servers support -> we need to have database support (single source of truth), since every server has seperate RAM, and data of state will be only with one server, so others are clueless of current state if request goes to some other server.
   > Different APIs can land at different servers. 
8. **Now we can write full-fledged code**
   1. Use factory design pattern to assign ENUM from DB to create IATMState objects
   2. Create Data Class - CardDetails with relevant getters and enums (CardType); So instead of passing multiple fields, we can wrap it in data class. And update IATMClass method definitions
9. **Card Manager Factory** on Card_Reading state:
   1. Algorithms for validating different types of card (credit, debit) would differ from each other
   2. 