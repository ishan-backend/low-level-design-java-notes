package atm.state;

public class WithdrawlDetailsReadingState implements IATMState{
    @Override
    public int initTxn() {
        return 0;
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
