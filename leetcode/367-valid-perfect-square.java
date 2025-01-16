class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num/2+1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long midSquared = mid * mid;
            if (num == midSquared) {
                return true;
            } else if (num > midSquared) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}