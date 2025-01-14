import java.util.HashMap;

class Solution {
    public int maxProfit(int[] prices) {
        // true -> buying, false -> selling
        HashMap<String, Integer> memo = new HashMap<>();
        return dfs(0, true, prices, memo);
    }

    private int dfs(int i, Boolean buying, int[] prices, HashMap<String, Integer> memo) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "-" + buying;
        if (memo.containsKey(key))
            return memo.get(key);

        // cooldown
        int cool = dfs(i + 1, buying, prices, memo);

        if (buying) {
            // buy
            int buy = dfs(i + 1, !buying, prices, memo) - prices[i];
            memo.put(key, Math.max(cool, buy));
        } else {
            // sell + cool
            int sell = dfs(i + 2, !buying, prices, memo) + prices[i];
            memo.put(key, Math.max(cool, sell));
        }
        return memo.get(key);
    }
}