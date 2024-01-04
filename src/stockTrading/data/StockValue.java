package stockTrading.data;

public class StockValue {
    private final int amount;
    private final Currency currency;
    private final int version;

    public StockValue(int amount, Currency currency, int version) {
        this.amount = amount;
        this.currency = currency;
        this.version = version;
    }

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getVersion() {
        return version;
    }
}
