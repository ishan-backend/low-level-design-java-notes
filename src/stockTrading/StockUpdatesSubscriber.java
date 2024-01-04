package stockTrading;

import stockTrading.data.StockName;
import stockTrading.data.StockValue;

import java.util.*;

public class StockUpdatesSubscriber implements IStockSubscriber{
    private final String name; // to distinguish between multiple instances of subsribers
    private Map<StockName, StockValue> stockValues; // local store of a publisher to which updates will actually push the update
    private List<IStockPublisher> publishers; // publishers to which we are subscribing

    public StockUpdatesSubscriber(String name) {
        this.name = name;
        this.stockValues = new HashMap<>();
        this.publishers = new ArrayList<>();
    }

    // todo: designing for multi-threaded systems, there can be race condition over the map
    // two ways in which you can make them synchronized
    @Override
    public void updateStock(StockName stockName, StockValue stockValue) {
        System.out.println(name + " " + stockName + " " + stockValue.getAmount() + stockValue.getCurrency() + " " + stockValue.getVersion());
        // check if you have value of stock in your map, if you don't add it in map
        // check the version number
        // decide to update or not
        if(stockValues.containsKey(stockName)) {
            if(stockValues.get(stockName).getVersion() < stockValue.getVersion()) {
                stockValues.put(stockName, stockValue);
            }
        } else {
            stockValues.put(stockName, stockValue);
        }
    }

    public Optional<StockValue> getStockValue(StockName stockName) {
        return Optional.ofNullable(stockValues.get(stockName));
    }
}
