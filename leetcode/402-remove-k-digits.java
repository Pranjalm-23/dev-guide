import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        // Remove remaining digits if k > 0
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        String ans = "";
        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        int subs = 0;
        for (char c : ans.toCharArray()) {
            if (c != '0')
                break;
            subs++;
        }
        ans = ans.substring(subs, ans.length());

        return ans != "" ? ans : "0";
    }
}