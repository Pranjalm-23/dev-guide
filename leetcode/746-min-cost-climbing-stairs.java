class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i % 2] = cost[i] + Math.min(dp[0], dp[1]);
        }

        return Math.min(dp[0], dp[1]);
    }
}