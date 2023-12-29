package atm.card;

public class DebitCardManager implements ICardManager{
    @Override
    public boolean validateCard(CardDetails cardDetails) {
        return true;
    }

    @Override
    public boolean validateWithdrawal(float amount, int transId) {
        return true;
    }

    @Override
    public void executeWithdrawal(int transId) {

    }
}
