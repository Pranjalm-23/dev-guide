class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        // size: nums1 < nums2

        int totalLength = m + n;
        int halfLength = (totalLength + 1) / 2;

        int l = 0, r = m;

        while (l <= r) {
            int part1 = l + (r - l) / 2;
            int part2 = halfLength - part1;

            int left1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int right1 = (part1 == m) ? Integer.MAX_VALUE : nums1[part1];

            int left2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int right2 = (part2 == n) ? Integer.MAX_VALUE : nums2[part2];

            if (left1 <= right2 && left2 <= right1) {
                if (totalLength % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2)
                r = part1 - 1;
            else
                l = part1 + 1;

        }
        return 0.0;
    }
}