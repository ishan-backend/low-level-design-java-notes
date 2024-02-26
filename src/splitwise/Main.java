package splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public int minTransactions(int[][] transactions) {
        Map<Integer, Integer> memberVsBalanceMap = new HashMap<>();
        for(int[] txn: transactions) {
            int from = txn[0];
            int to = txn[1];
            int amount = txn[2];
            memberVsBalanceMap.put(from, memberVsBalanceMap.getOrDefault(from, 0) - amount);
            memberVsBalanceMap.put(to, memberVsBalanceMap.getOrDefault(to, 0) + amount);
        }

        // put into balance list
        List<Integer> balances = new ArrayList<>();
        for(int amount: memberVsBalanceMap.values()) {
            if(amount != 0) {
                balances.add(amount);
            }
        }

        return dfs(balances, 0); // 0th index in this balances list, will return minimum length of dfs
    }

    int dfs(List<Integer> balances, int idx) {
        if(balances.size() == 0 || idx >= balances.size()) return 0;
        if(balances.get(idx) == 0) // safety check
            return dfs(balances, idx+1);

        int currentVal = balances.get(idx);
        int minmTxnCount = Integer.MAX_VALUE;
        for(int i=idx+1; idx < balances.size(); i++) {
            int nextVal = balances.get(i);
            if(currentVal * nextVal < 0) {
                // either one is positive or negative, txn can happen -> make the transaction to nextIdx here i, since currentIndex idx will get skipped
                balances.set(i, currentVal+nextVal);
                minmTxnCount = Math.min(minmTxnCount, 1 + dfs(balances, idx+1)); // dfs
                // backtracking, reset to old val
                balances.set(i, nextVal);

                if(currentVal + nextVal == 0)
                    break;
            }
        }

        return minmTxnCount;
    }
}
