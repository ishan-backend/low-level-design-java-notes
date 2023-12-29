package atm.state;

public interface IATMState {
    int initTxn();
    boolean cancelTxn(int txnId);
    boolean isCardValidOnRead(String cardType, long cardNum, int pin, String name);
    boolean readWithdrawlDetails(String cardType, long cardNum, int pin, String name, int amount);
    boolean dispenseCash(int txnId);
    void ejectCard();
}
