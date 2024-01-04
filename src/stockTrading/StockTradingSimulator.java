package stockTrading;

import stockTrading.data.Currency;
import stockTrading.data.StockName;
import stockTrading.data.StockValue;

public class StockTradingSimulator {
    public static void main(String[] args) {
        // create publishers
        StockUpdatesPublisher BSEPublisher = new StockUpdatesPublisher("BSE");
        StockUpdatesPublisher NSEPublisher = new StockUpdatesPublisher("NSE");

        // create subscribers
        StockUpdatesSubscriber subs1 = new StockUpdatesSubscriber("subs_1");
        StockUpdatesSubscriber subs2 = new StockUpdatesSubscriber("subs_2");
        StockUpdatesSubscriber subs3 = new StockUpdatesSubscriber("subs_3");

        // make subscriptions
        NSEPublisher.subscribe(subs1);
        NSEPublisher.subscribe(subs2);
        BSEPublisher.subscribe(subs1);
        BSEPublisher.subscribe(subs3);

        // NSE notifies
        NSEPublisher.notifySubscribers(StockName.GGL, new StockValue(100, Currency.INR, 1));
        NSEPublisher.notifySubscribers(StockName.GGL, new StockValue(150, Currency.INR, 2));

        // BSE notifies
        BSEPublisher.notifySubscribers(StockName.GGL, new StockValue(100, Currency.INR, 1));
        BSEPublisher.notifySubscribers(StockName.TCS, new StockValue(56, Currency.INR, 1));

        // now subs1, should not consume BSE - GGL update to update map
        System.out.println(subs1.getStockValue(StockName.GGL).get().getAmount());
        System.out.println(subs3.getStockValue(StockName.GGL).get().getAmount());
    }
}
