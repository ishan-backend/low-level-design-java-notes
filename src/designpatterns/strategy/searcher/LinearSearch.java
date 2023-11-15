package designpatterns.strategy.searcher;

import java.util.List;

public class LinearSearch implements Searcher{
    @Override
    public Integer search(Integer key, List<Integer> nums) {
        System.out.println("inside LinearSearcher");
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == key)
                return i;
        }
        return -1;
    }
}
