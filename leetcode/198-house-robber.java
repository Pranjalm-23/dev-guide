import java.util.*;

class SolutionMemo {
    public int rob(int[] nums) {
        int n = nums.length;
        return rob(n - 1, nums);
    }

    private HashMap<Integer, Integer> memo = new HashMap<>();

    private int rob(int n, int[] nums) {
        if (n == 0)
            return nums[0];
        if (n == 1)
            return Math.max(nums[0], nums[1]);
        if (memo.containsKey(n))
            return memo.get(n);
        memo.put(n, Math.max(rob(n - 1, nums), nums[n] + rob(n - 2, nums)));
        return memo.get(n);
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = { nums[0], Math.max(nums[0], nums[1]) };

        for (int i = 2; i < nums.length; i++) {
            dp[i % 2] = Math.max(nums[i] + dp[i % 2], dp[(i - 1) % 2]);
        }
        return dp[(nums.length - 1) % 2];
    }
}