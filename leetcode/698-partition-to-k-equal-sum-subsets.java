import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum % k != 0)
            return false;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        return dfsCheckBack(nums, k, sum / k, 0, 0, used);
    }

    private boolean dfsCheckBack(int[] nums, int k, int targetSum, int curSum, int i, boolean[] used) {
        if (k == 1)
            return true;
        if (curSum == targetSum)
            return dfsCheckBack(nums, k - 1, targetSum, 0, 0, used);

        for (int j = i; j < nums.length; j++) {
            if (used[j])
                continue;
            if (curSum + nums[j] > targetSum)
                continue;

            used[j] = true;
            if (dfsCheckBack(nums, k, targetSum, curSum + nums[j], j + 1, used))
                return true;
            used[j] = false;
        }
        return false;
    }
}