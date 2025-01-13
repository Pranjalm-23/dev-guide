import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;
        Boolean[] dp = new Boolean[sum / 2 + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        // checking all possible sums we can have till our need
        for (int num : nums) {
            for (int i = dp.length - 1; i > 0; i--) {
                if (i - num >= 0) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum / 2];
    }
}