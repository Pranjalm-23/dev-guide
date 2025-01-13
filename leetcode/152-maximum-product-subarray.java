class Solution {
    public int maxProduct(int[] nums) {
        int minEndingHere = nums[0];
        int maxEndingHere = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int oldminEndingHere = minEndingHere;
            minEndingHere = Math.min(nums[i] * oldminEndingHere, nums[i] * maxEndingHere);
            minEndingHere = Math.min(minEndingHere, nums[i]);
            maxEndingHere = Math.max(nums[i] * oldminEndingHere, nums[i] * maxEndingHere);
            maxEndingHere = Math.max(maxEndingHere, nums[i]);
            ans = Math.max(ans, maxEndingHere);
        }
        return ans;
    }
}