import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>(); // maintained as mono decreasing
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                // out of window
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                // add latest & maximum idx
                dq.pollLast();
            }

            dq.offerLast(i);
            if (i >= k - 1)
                ans[i - k + 1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}