import java.util.Stack;
import javafx.util.Pair;

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Pair<Integer, Integer>> st = new Stack<>(); // mono decresing stack: val, mintillnow
        int currMin = nums[0];
        for (int n : nums) {
            while (!st.isEmpty() && st.peek().getKey() <= n)
                st.pop();

            if (!st.isEmpty() && n > st.peek().getValue())
                return true;
            st.push(new Pair<>(n, currMin));
            currMin = Math.min(currMin, n);
        }
        return false;
    }
}