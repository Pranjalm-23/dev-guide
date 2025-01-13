class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }
        return dp[n % 2];
    }
}