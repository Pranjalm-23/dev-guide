import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxf = 0;
        long windowSum = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            // expand
            windowSum += nums[r];
            while ((long) nums[r] * (r - l + 1) > windowSum + k) {
                // shrink
                windowSum -= nums[l];
                l++;
            }
            maxf = Math.max(maxf, r - l + 1);
        }
        return maxf;
    }
}