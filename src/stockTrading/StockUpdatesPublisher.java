package stockTrading;

import stockTrading.data.StockName;
import stockTrading.data.StockValue;

import java.util.ArrayList;
import java.util.List;

public class StockUpdatesPublisher implements IStockPublisher{
    private final String publisherName; // to differentiate between publishers
    private List<IStockSubscriber> subscribers;

    public StockUpdatesPublisher(String publisherName) {
        this.publisherName = publisherName;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(IStockSubscriber stockSubscriber) {
        this.subscribers.add(stockSubscriber);
    }

    @Override
    public void unsubscribe(IStockSubscriber stockSubscriber) {
        this.subscribers.remove(stockSubscriber);
    }

    @Override
    public void notifySubscribers(StockName stockName, StockValue stockValue) {
        for(IStockSubscriber stockSubscriber: this.subscribers) {
            stockSubscriber.updateStock(stockName, stockValue);
        }
    }
}
