package stockTrading;

import stockTrading.data.StockName;
import stockTrading.data.StockValue;

public interface IStockPublisher {
    void subscribe(IStockSubscriber stockSubscriber);
    void unsubscribe(IStockSubscriber stockSubscriber);
    void notifySubscribers(StockName stockName, StockValue stockValue);
}
