package atm.state;

import atm.card.CardDetails;

public interface IATMState {
    int initTxn();
    boolean cancelTxn(int txnId);
    //    boolean isCardValidOnRead(String cardType, long cardNum, int pin, String name);
    boolean isCardValidOnRead(CardDetails cardDetails);
    //    boolean readWithdrawlDetails(String cardType, long cardNum, int pin, String name, int amount);
    boolean readWithdrawlDetails(CardDetails cardDetails, int txnId, float amount);
    float dispenseCash(int txnId);
    void ejectCard();

    // returns ENUM corresponding to state object
    ATMState getStateName();
}
