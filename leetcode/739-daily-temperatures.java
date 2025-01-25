import java.util.Stack;
import javafx.util.Pair;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> st = new Stack<>(); // temp, idx
        int[] ans = new int[temperatures.length];
        int idx = 0;

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && st.peek().getKey() < temperatures[i]) {
                Pair<Integer, Integer> p = st.pop();
                ans[p.getValue()] = i - p.getValue();
            }
            st.push(new Pair<>(temperatures[i], i));
        }
        return ans;
    }
}