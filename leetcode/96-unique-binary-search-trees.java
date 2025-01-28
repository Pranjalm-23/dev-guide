import java.util.Arrays;

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for (int i = 2; i < n + 1; i++) {
            int total = 0;
            for (int root = 1; root <= i; root++) {
                int left = root - 1;
                int right = i - root;
                total += dp[left] * dp[right];
            }
            dp[i] = total;
        }
        return dp[n];
    }
}