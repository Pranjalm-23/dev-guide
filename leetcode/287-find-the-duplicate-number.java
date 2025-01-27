class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int modi = Math.abs(nums[i]);
            if (nums[modi] < 0)
                return modi;
            nums[modi] = (-1) * nums[modi];
        }
        return -1;
    }
}

class SolutionFloyds {
    public int findDuplicate(int[] nums) {
        // floyds cycle detection
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}