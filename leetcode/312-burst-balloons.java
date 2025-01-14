import java.util.Arrays;

class Solution {
    public int maxCoins(int[] nums) {
        // add 1 at begin and end
        int[] supernums = new int[nums.length + 2];
        for (int i = 0; i < supernums.length; i++) {
            if (i == 0 || i == supernums.length - 1)
                supernums[i] = 1;
            else
                supernums[i] = nums[i - 1];
        }
        int[][] cache = new int[supernums.length][supernums.length];
        for (int[] arr : cache)
            Arrays.fill(arr, -1);
        return dfs(supernums, 1, supernums.length - 2, cache);

    }

    private int dfs(int[] nums, int l, int r, int[][] cache) {
        if (l > r)
            return 0;
        if (cache[l][r] != -1)
            return cache[l][r];

        cache[l][r] = 0;
        // checking all possibilities for bursting last
        for (int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(nums, l, i - 1, cache) + dfs(nums, i + 1, r, cache);
            cache[l][r] = Math.max(cache[l][r], coins);
        }
        return cache[l][r];
    }
}