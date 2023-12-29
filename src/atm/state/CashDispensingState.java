package atm.state;

import atm.ATM.ATM;
import atm.card.CardDetails;
import atm.card.CardManagerFactory;
import atm.card.CardType;
import atm.db.DBAccessor;

public class CashDispensingState implements IATMState{
    private final ATM atm; // since we want to change ATM class state from here

    public CashDispensingState(ATM atm) {
        this.atm = atm;
    }
    @Override
    public int initTxn() {
        return 0;
    }

    @Override
    public boolean cancelTxn(int txnId) {
        DBAccessor.cancelTransaction(txnId);
        this.atm.changeState(new CardEjectingState(this.atm));
        return true;
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
        // using txnId, figure out cardDetails and figure out cardType
        CardType cardType = null;
        // assume you get it via some logic
        cardType = CardType.DEBIT;
        CardManagerFactory.getCardManager(cardType).executeWithdrawal(txnId);
        return DBAccessor.markAsExec(txnId);
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException();
    }

    @Override
    public ATMState getStateName() {
        return ATMState.CASH_DISPENSING;
    }
}
