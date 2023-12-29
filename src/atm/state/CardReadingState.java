package atm.state;

import atm.ATM.ATM;
import atm.card.CardDetails;
import atm.card.CardManagerFactory;
import atm.db.DBAccessor;

public class CardReadingState implements IATMState{
    private final ATM atm; // since we want to change ATM class state from here

    public CardReadingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTxn() {
        throw new IllegalStateException();
    }

    @Override
    public boolean cancelTxn(int txnId){
        DBAccessor.cancelTransaction(txnId);
        this.atm.changeState(new ReadyState(this.atm));
        return true;
    }

    @Override
    public boolean isCardValidOnRead(CardDetails cardDetails) {
        boolean result = CardManagerFactory.getCardManager(cardDetails.getCardType()).validateCard(cardDetails);
        // persist the card details for running txn in db
        DBAccessor.persistCardDetails(cardDetails, this.atm.getMachineId());
        // once we have result, depending on it do certain things
        if(result) {
            this.atm.changeState(new WithdrawlDetailsReadingState(this.atm));
        } else {
            DBAccessor.disapproveTransaction(this.atm.getMachineId()); // we will sometimes be approving, disapproving txn, so we need ENUM for transaction status
            this.atm.changeState(new ReadyState(this.atm));
            return false;
        }

        return true;
    }

    @Override
    public boolean readWithdrawlDetails(CardDetails cardDetails, int transId, float amount) {
        throw new IllegalStateException();
    }

    @Override
    public float dispenseCash(int txnId){
        throw new IllegalStateException();
    }

    @Override
    public void ejectCard(){
        throw new IllegalStateException();
    }

    @Override
    public ATMState getStateName() {
        return ATMState.CARD_READING;
    }
}
