class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i < dp.length; i++) {
                if ((i + coin) < dp.length) {
                    dp[i + coin] += dp[i];
                }
            }
        }
        return dp[amount];
    }
}