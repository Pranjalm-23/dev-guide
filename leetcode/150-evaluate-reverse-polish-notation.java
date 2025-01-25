import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (token.equals("-")) {
                int subtrahend = st.pop();
                st.push(st.pop() - subtrahend);
            } else if (token.equals("/")) {
                int divisor = st.pop();
                st.push(st.pop() / divisor);
            } else if (token.equals("*")) {
                st.push(st.pop() * st.pop());
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}