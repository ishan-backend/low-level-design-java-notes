package atm.card;

public class CardManagerFactory {
    private CardManagerFactory() {}

    public static ICardManager getCardManager(CardType cardType) {
        ICardManager cardManager = null;
        if(cardType.equals(CardType.CREDIT)) {
            cardManager = new CreditCardManager();
        } else if(cardType.equals(CardType.DEBIT)) {
            cardManager = new DebitCardManager();
        } else {
            throw new IllegalArgumentException();
        }

        return cardManager;
    }
}
