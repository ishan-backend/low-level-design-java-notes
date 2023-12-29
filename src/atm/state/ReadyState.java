package atm.state;

import atm.ATM.ATM;
import atm.card.CardDetails;
import atm.db.DBAccessor;

public class ReadyState implements IATMState{
    private final ATM atm; // since we want to change ATM class state from here

    public ReadyState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTxn() {
        int txnId = 0;
        // logic to generate UUID, persist in DB
        txnId = DBAccessor.createNewTransaction(this.atm.getMachineId());
        if(txnId == 0) {
            throw new RuntimeException("Unable to start txn");
        }

        this.atm.changeState(new CardReadingState(this.atm));
        return txnId;
    }

    @Override
    public boolean isCardValidOnRead(CardDetails cardDetails) {
        throw new IllegalStateException("Currently in ready state, can't read card");
    }

    @Override
    public boolean cancelTxn(int transId) {
        throw new IllegalStateException("No Transaction in progress");
    }

    @Override
    public boolean readWithdrawlDetails(CardDetails cardDetails, int transId, float amount) {
        throw new IllegalStateException("Currently in ready state, can't read WithdrawalDetails");
    }

    @Override
    public float dispenseCash(int transId) {
        throw new IllegalStateException("Currently in ready state, can't dispense Cash");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Currently in ready state, can't eject Card");
    }

    @Override
    public ATMState getStateName() {
        return ATMState.READY;
    }
}
