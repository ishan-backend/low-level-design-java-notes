package atm.state;

import atm.ATM.ATM;
import atm.card.CardDetails;

public class CardEjectingState implements IATMState{
    private final ATM atm; // since we want to change ATM class state from here

    public CardEjectingState(ATM atm) {
        this.atm = atm;
    }
    @Override
    public int initTxn() {
        throw new IllegalStateException();
    }

    @Override
    public boolean cancelTxn(int txnId) {
        throw new IllegalStateException();
    }

    @Override
    public boolean isCardValidOnRead(CardDetails cardDetails) {
        throw new IllegalStateException();
    }

    @Override
    public boolean readWithdrawlDetails(CardDetails cardDetails, int transId, float amount) {
        throw new IllegalStateException();
    }

    @Override
    public float dispenseCash(int txnId) {
        throw new IllegalStateException();
    }

    @Override
    public void ejectCard() {
        this.atm.changeState(new ReadyState(this.atm));
        // record in DB at what time card was ejected
    }


    @Override
    public ATMState getStateName() {
        return ATMState.CARD_EJECTING;
    }
}
