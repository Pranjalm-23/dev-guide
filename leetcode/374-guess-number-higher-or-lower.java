/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

 class Solution {

    // Forward declaration of guess API.
    private int guess(int num) {
        // This is a placeholder implementation.
        // Replace this with the actual implementation.
        return 0;
    }
    public int guessNumber(int n) {
        int l = 0, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int ans = guess(mid);
            if (ans == 0) {
                return mid;
            } else if (ans == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}