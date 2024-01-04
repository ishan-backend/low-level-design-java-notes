package stockTrading;

import stockTrading.data.StockName;
import stockTrading.data.StockValue;

public interface IStockSubscriber {
    void updateStock(StockName stockName, StockValue stockValue);
}
