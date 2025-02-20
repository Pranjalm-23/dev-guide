import java.util.*;
import javafx.util.Pair;

class Solution {
    public int maxSumMinProduct(int[] nums) {
        // mono increasing stack
        int MOD = 1_000_000_007;
        Stack<Pair<Integer, Integer>> st = new Stack<>(); // startIdx, val
        long[] preSum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int newStartIdx = i;
            while (!st.isEmpty() && st.peek().getValue() > nums[i]) {
                Pair<Integer, Integer> p = st.pop();
                int start = p.getKey();
                int val = p.getValue();
                long total = preSum[i] - preSum[start];
                ans = Math.max(ans, val * total);
                newStartIdx = start;
            }
            st.push(new Pair<>(newStartIdx, nums[i]));
        }

        for (Pair<Integer, Integer> p : st) {
            long total = preSum[nums.length] - preSum[p.getKey()];
            ans = Math.max(ans, p.getValue() * total);
        }

        return (int) (ans % MOD);
    }
}