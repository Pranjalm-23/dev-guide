import java.util.Stack;
import javafx.util.Pair;

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>(); // char, count

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().getKey() == c) {
                st.push(new Pair<>(c, st.pop().getValue() + 1));
                if (st.peek().getValue() == k)
                    st.pop();
            } else
                st.push(new Pair<>(c, 1));
        }
        // String ans = "";
        // for (Pair<Character, Integer> pair : st) {
        //     int t = pair.getValue();
        //     while (t-- > 0)
        //         ans += pair.getKey();
        // }
        // return ans;
        // Build the final string using StringBuilder
        StringBuilder ans = new StringBuilder();
        for (Pair<Character, Integer> pair : st) {
            ans.append(String.valueOf(pair.getKey()).repeat(pair.getValue()));
        }

        return ans.toString();
    }
}