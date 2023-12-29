package atm.ATM;

import atm.state.IATMState;
import atm.state.ReadyState;

public class ATM {

    public final String machineId;
//    private ATMState atmState;
    private IATMState atmState; // given atmState is private field, we won't be able to change it directly from concrete state classes, so we need a setter

    public ATM(String machineId) {
        this.machineId = machineId;
//        this.atmState = ATMState.READY;
        this.atmState = new ReadyState(this); // atmState is interface, so it can be = new of any class that implements this interface, this denotes current ATM instance
    }

    public int initTxn() {
        /*
         we must allow only initTxn when ATM state is in READY, this will handle not allowing concurrent users
         otherwise, throw relevant exception (involves lots of if-else conditions)
         Also, this does not abide by OCP (Open Closed Principle)

        if(atmState.equals(ATMState.CARD_READING)) {
            throw new IllegalStateException("old txn in card_reading, operation not allowed");
        }
        if(atmState.equals(ATMState.WITHDRAWL_DETAILS_READING)) {
            throw new IllegalStateException("old txn in withdrawl_details_reading, operation not allowed");
        }
        if(atmState.equals(ATMState.CASH_DISPENSING)) {
            throw new IllegalStateException("old txn in cash_dispensing, operation not allowed");
        }
        if(atmState.equals(ATMState.CARD_EJECTING)) {
            throw new IllegalStateException("old txn in card_ejecting, operation not allowed");
        }

         this, otherwise can be handled by state machine itself
        */


        /*
         logic to generate uuid is separate topic and out of scope of this design
         connect to the database
         persist it in database
         skipping it since it is implementation specific

            int txnId = 0;
            this.atmState = ATMState.CARD_READING;
        */

        // initTxn of that class will be called which is currently injected over here
        return this.atmState.initTxn(); // delegate initTxn to state based concrete implementation, and whatever that returns this function also returns

        /*
            this.atmState = new CardReadingState();
            return txnId;
             - Still we would violate DIP
             - We would need to know our current state, for us to decide next state

             Let's say, we want to delegate this state change to concrete class down,
             we might have to pass instance/reference of ATM class to this function down below
        */
    }
    public boolean cancelTxn(int txnId){
        return this.atmState.cancelTxn(txnId);
    }
    public boolean isCardValidOnRead(String cardType, long cardNum, int pin, String name){
        return this.atmState.isCardValidOnRead(cardType, cardNum, pin, name);
    }
    public boolean readWithdrawlDetails(String cardType, long cardNum, int pin, String name, int amount) {
        return this.atmState.readWithdrawlDetails(cardType, cardNum, pin, name, amount);
    }
    public boolean dispenseCash(int txnId){
        return this.atmState.dispenseCash(txnId);
    }
    public void ejectCard(){
        this.atmState.ejectCard();
    }

    public void changeState(IATMState newState){this.atmState = newState;}
}
