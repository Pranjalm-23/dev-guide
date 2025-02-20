class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for (int b : piles) {
            max = Math.max(max, b);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (canEat(piles, h, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canEat(int[] piles, int h, int speed) {
        int t = 0;
        for (int n : piles) {
            t += Math.ceil((double) n / speed);// ceil
        }

        return t <= h;
    }
}