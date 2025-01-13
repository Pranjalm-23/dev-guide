class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = { nums[0], Math.max(nums[0], nums[1]) };

        for (int i = 2; i < nums.length - 1; i++) {
            dp[i % 2] = Math.max(nums[i] + dp[i % 2], dp[(i - 1) % 2]);
        }
        int ans = dp[(nums.length - 2) % 2];
        
        if (nums.length > 2) {
            int[] dp2 = new int[2];
            dp2[1] = nums[1];
            dp2[0] = Math.max(nums[1], nums[2]);

            for (int i = 3; i < nums.length; i++) {
                dp2[i % 2] = Math.max(nums[i] + dp2[i % 2], dp2[(i - 1) % 2]);
            }
            if (dp2[(nums.length - 1) % 2] > ans) {
                ans = dp2[(nums.length - 1) % 2];
            }
        } else {
            ans = dp[(nums.length - 1) % 2];
        }
        return ans;
    }
}