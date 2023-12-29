package atm.state;

import atm.ATM.ATM;

public class ATMStateFactory {
    private ATMStateFactory(){}
    public static IATMState getState(ATMState atmState, ATM atm){
        IATMState state = null;
        if(atmState.equals(ATMState.READY)) {
            state = new ReadyState(atm);
        } else if (atmState.equals(ATMState.CARD_READING)) {
            state = new CardReadingState(atm);
        } else if (atmState.equals(ATMState.WITHDRAWL_DETAILS_READING)) {
            state = new WithdrawlDetailsReadingState(atm);
        } else if (atmState.equals(ATMState.CASH_DISPENSING)) {
            state = new CashDispensingState(atm);
        } else if (atmState.equals(ATMState.CARD_EJECTING)) {
            state = new CardEjectingState(atm);
        } else {
            throw new IllegalArgumentException("invalid state passed");
        }

        return state;
    }
}
