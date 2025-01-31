package atm.state;

import atm.ATM.ATM;
import atm.card.CardDetails;
import atm.card.CardManagerFactory;
import atm.db.DBAccessor;

public class WithdrawlDetailsReadingState implements IATMState{
    private final ATM atm; // since we want to change ATM class state from here

    public WithdrawlDetailsReadingState(ATM atm) {
        this.atm = atm;
    }
    @Override
    public int initTxn() {
        throw new IllegalStateException();
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
        boolean res = CardManagerFactory.getCardManager(cardDetails.getCardType()).validateWithdrawal(amount, transId);
        if(res) {
            this.atm.changeState(new CashDispensingState(this.atm));
            DBAccessor.persistWithDetails(transId, amount, TransactionState.APPROVED);
        } else {
            this.atm.changeState(new CardEjectingState(this.atm));
            DBAccessor.persistWithDetails(transId, amount, TransactionState.NOT_APPROVED);
        }
        return res;
    }

    @Override
    public float dispenseCash(int txnId) {
        throw new IllegalStateException();
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException();
    }

    @Override
    public ATMState getStateName() {
        return ATMState.WITHDRAWL_DETAILS_READING;
    }
}
