package atm.state;

import atm.ATM.ATM;

public class CardReadingState implements IATMState{
    private final ATM atm; // since we want to change ATM class state from here

    public CardReadingState(ATM atm) {
        this.atm = atm;
    }

    public int initTxn() {return 0;}
    public boolean cancelTxn(int txnId){return true;}
    public boolean isCardValidOnRead(String cardType, long cardNum, int pin, String name){return true;}
    public boolean readWithdrawlDetails(String cardType, long cardNum, int pin, String name, int amount) {return true;}
    public boolean dispenseCash(int txnId){return true;}
    public void ejectCard(){}
}
