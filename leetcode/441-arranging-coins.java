class Solution {
    public int arrangeCoins(int n) {
        long l = 0, r = n;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long coins = mid * (mid + 1) / 2;
            if (coins == n) {
                return (int) mid;
            } else if (coins > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) r;
    }
}