class Solution {
    public int splitArray(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        // checking all possibility in the range
        // Minumum Largest Sum > max(all the nums), < (sum of all)
        int high = 0, low = 0;

        for (int n : nums) {
            high += n;
            low = Math.max(low, n);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(nums, mid, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isFeasible(int[] nums, int largest, int k) {
        int subarr = 0;
        int currSum = 0;

        for (int num : nums) {
            currSum += num;
            if (currSum > largest) {
                subarr += 1;
                currSum = num;
                if (subarr >= k)
                    return false;
            }
        }
        return subarr + 1 <= k;
    }
}