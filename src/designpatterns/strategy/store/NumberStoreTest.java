package designpatterns.strategy.store;

import designpatterns.strategy.inserter.OrderedInserter;
import designpatterns.strategy.searcher.BinarySearch;

public class NumberStoreTest {

    public static void main(String[] args) {
        NumberStore numberStore = new NumberStore(
                new OrderedInserter(),
                new BinarySearch()
        );
        numberStore.insert(1);
        numberStore.insert(0);
        numberStore.insert(10);
        numberStore.insert(2);
        System.out.println(numberStore.search(10));
    }

}
