import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String s : operations) {
            if (s.equals("C"))
                st.pop();
            else if (s.equals("D"))
                st.push(st.peek() * 2);
            else if (s.equals("+")) {
                int last = st.pop();
                int sum = last + st.peek();
                st.push(last);
                st.push(sum);
            } else {
                int n = Integer.parseInt(s);
                st.push(n);
            }
        }
        int ans = 0;
        while (!st.isEmpty())
            ans += st.pop();
        return ans;
    }
}