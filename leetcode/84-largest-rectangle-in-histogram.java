import java.util.*;
import javafx.util.Pair;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        // Maintaining mono increasing stack
        Stack<Pair<Integer, Integer>> st = new Stack<>();

        for(int i = 0; i < heights.length; i++){
            int start = i;
            while (!st.isEmpty() && st.peek().getKey() > heights[i]) {
                Pair<Integer, Integer> p = st.pop();
                max = Math.max(max, p.getKey() * (i - p.getValue()));
                start = p.getValue(); // Update the start to the leftmost index
            }
            st.push(new Pair<>(heights[i], start));
        }
// Process remaining
        while (!st.isEmpty()) {
            Pair<Integer, Integer> p = st.pop();
            max = Math.max(max, p.getKey() * (heights.length - p.getValue()));
        }
        return max;
    }
}