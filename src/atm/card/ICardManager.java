package atm.card;

public interface ICardManager {
    boolean validateCard(CardDetails cardDetails);

    boolean validateWithdrawal(float amount, int transId);

    void executeWithdrawal(int transId);
}
