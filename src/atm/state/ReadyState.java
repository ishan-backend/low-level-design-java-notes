package atm.state;

import atm.ATM.ATM;

public class ReadyState implements IATMState{
    private final ATM atm; // since we want to change ATM class state from here

    public ReadyState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTxn() {
        int txnId = 0;
        // logic to generate UUID, persist in DB
        this.atm.changeState(new CardReadingState(this.atm));
        return txnId;
    }

    @Override
    public boolean cancelTxn(int txnId) {
        return false;
    }

    @Override
    public boolean isCardValidOnRead(String cardType, long cardNum, int pin, String name) {
        return false;
    }

    @Override
    public boolean readWithdrawlDetails(String cardType, long cardNum, int pin, String name, int amount) {
        return false;
    }

    @Override
    public boolean dispenseCash(int txnId) {
        return false;
    }

    @Override
    public void ejectCard() {

    }
}
