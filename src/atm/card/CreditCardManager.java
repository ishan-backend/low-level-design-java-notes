package atm.card;

public class CreditCardManager implements ICardManager{
    @Override
    public boolean validateCard(CardDetails cardDetails) {
        return false;
    }

    @Override
    public boolean validateWithdrawal(float amount, int transId) {
        return false;
    }

    @Override
    public void executeWithdrawal(int transId) {

    }
}
